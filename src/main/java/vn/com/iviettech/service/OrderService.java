package vn.com.iviettech.service;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vn.com.iviettech.domain.OrderTotalDTO;
import vn.com.iviettech.entity.OrderDetailEntity;
import vn.com.iviettech.entity.OrderEntity;
import vn.com.iviettech.repository.OrderDetailRepository;
import vn.com.iviettech.repository.OrderRepository;


import java.util.*;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final OrderDetailRepository detailRepository;

    public OrderService(OrderRepository orderRepository,
                        OrderDetailRepository detailRepository) {
        this.orderRepository = orderRepository;
        this.detailRepository = detailRepository;
    }

    @Transactional
    @PostConstruct
    public void init() {
        Scanner sc = new Scanner(System.in);
        System.out.println("----- MENU -----");
        System.out.println("1. Nhập đơn hàng mới");
        System.out.println("2. Liệt kê tất cả đơn hàng");
        System.out.println("3. Tìm kiếm đơn hàng theo id");
        System.out.println("4. Liệt kê đơn hàng theo tháng");
        System.out.println("5. Liệt kê các đơn hàng có giá trị lơn hơn 100000VND");
        System.out.println("6: Liệt kê tất cả các đơn hàng mua sách Java");
        System.out.print(" Nhập lựa chọn: ");
        int choice = Integer.parseInt(sc.nextLine());

        switch (choice) {
            case 1:
                createOrderFromConsole();
                break;
            case 2:
                printAllOrdersWithDetails();
                break;
            case 3:
                findOrderByIdFromConsole();
                break;
            case 4:
                listOrdersInCurrentMonth();
            case  5:
                listOrdersWithTotalGreaterThan1000();
            case  6:
                listOrdersBuyingJavaBooks();
            default:
                System.out.println("Lựa chọn không hợp lệ.");
        }
    }
    @Transactional
    public void createOrderFromConsole(){
        Scanner sc = new Scanner(System.in);
        OrderEntity order = new OrderEntity();

        System.out.print("Nhập tên khách hàng: ");
        String name = sc.nextLine();
        order.setCustomerName(name);

        System.out.print("Nhập địa chỉ khách hàng: ");
        String address = sc.nextLine();
        order.setCustomerAddress(address);

        order.setOrderDate(new Date());
        orderRepository.save(order);

        List<OrderDetailEntity> detailList = new ArrayList<>();

        System.out.print("Nhập số lượng sản phẩm: ");
        int n = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < n; i++) {
            System.out.println(" Sản phẩm thứ " + (i + 1) );

            OrderDetailEntity detail = new OrderDetailEntity();

            System.out.print("Tên sản phẩm: ");
            String productName = sc.nextLine();
            detail.setProductName(productName);

            System.out.print("Số lượng: ");
            int quatity = sc.nextInt();
            detail.setQuantity(quatity);
            sc.nextLine();

            System.out.print("Đơn giá: ");
            Double unitPrice = sc.nextDouble();
            detail.setUnitPrice(unitPrice);
            sc.nextLine();

            detail.setOrder(order); // liên kết
            detailList.add(detail);

            detailRepository.save(detail);
        }

        order.setOrderDetails(detailList);
        orderRepository.save(order);


        System.out.println("Đơn hàng đã được lưu thành công!");
        for (OrderDetailEntity orderDetail : order.getOrderDetails()) {
            System.out.printf("- %s | SL: %d | Giá: %.0f\n",
                    orderDetail.getProductName(),
                    orderDetail.getQuantity(),
                    orderDetail.getUnitPrice());
        }
    }//nhập 1 đơn hàng mới vào csdl
    @Transactional(readOnly = true)
    public void printAllOrdersWithDetails() {
        List<OrderEntity> orders = orderRepository.findAll();

        if (orders.isEmpty()) {
            System.out.println("Không có đơn hàng nào.");
            return;
        }

        for (OrderEntity order : orders) {
            System.out.println("=======================================");
            System.out.println("Mã đơn hàng: " + order.getId());
            System.out.println("Tên KH: " + order.getCustomerName());
            System.out.println("Địa chỉ: " + order.getCustomerAddress());
            System.out.println("Ngày đặt: " + order.getOrderDate());
            System.out.println("Danh sách sản phẩm:");

            double total = 0;

            for (OrderDetailEntity detail : order.getOrderDetails()) {
                double tongtien = detail.getQuantity() * detail.getUnitPrice();
                total += tongtien;

                System.out.printf("- %s | SL: %d | Giá: %.0f | Thành tiền: %.0f\n",
                        detail.getProductName(),
                        detail.getQuantity(),
                        detail.getUnitPrice(), tongtien);
            }

            System.out.printf("Tổng tiền đơn hàng: %.0f VND\n", total);
        }
    }// liệt kê ĐH và CTĐH trong CSDL

    public void findOrderByIdFromConsole() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập ID đơn hàng cần tìm: ");
        int id = Integer.parseInt(sc.nextLine());

        Optional<OrderEntity> optionalOrder = orderRepository.findOrderWithDetails(id);

        if (optionalOrder.isPresent()) {
            OrderEntity order = optionalOrder.get();
            System.out.println("Tên khách hàng: " + order.getCustomerName());
            System.out.println("Địa chỉ: " + order.getCustomerAddress());
            System.out.println("Ngày đặt: " + order.getOrderDate());

            System.out.println("Danh sách sản phẩm:");
            for (OrderDetailEntity detail : order.getOrderDetails()) {
                System.out.printf("- %s | SL: %d | Giá: %.0f\n",
                        detail.getProductName(),
                        detail.getQuantity(),
                        detail.getUnitPrice());
            }
        } else {
            System.out.println("Không tìm thấy đơn hàng có ID = " + id);
        }
    } //tìm kiếm đơn hang theo order

    public void listOrdersInCurrentMonth() {
        Date now = new Date();
        @SuppressWarnings("deprecation")
        int month = now.getMonth() + 1; // tháng bắt đầu từ 0
        @SuppressWarnings("deprecation")
        int year = now.getYear() + 1900;

        List<OrderEntity> orders = orderRepository.findAllByMonthAndYear(month, year);

        System.out.println(" Danh sách đơn hàng trong tháng " + month + "/" + year);
        for (OrderEntity order : orders) {
            System.out.println("ID: " + order.getId());
            System.out.println("Khách hàng: " + order.getCustomerName());
            System.out.println("Địa chỉ: " + order.getCustomerAddress());
            System.out.println("Ngày đặt: " + order.getOrderDate());
            System.out.println("------------------------------");
        }

        if (orders.isEmpty()) {
            System.out.println("Không có đơn hàng nào trong tháng này.");
        }
    }//liệt kê đơn hang theo tháng

    @Transactional(readOnly = true)
    public void listOrdersWithTotalGreaterThan1000() {
        List<OrderTotalDTO> orders = detailRepository.findOrdersWithTotalGreaterThan1000();

        if (orders.isEmpty()) {
            System.out.println("Không có đơn hàng nào có tổng tiền > 1000 USD.");
            return;
        }

        System.out.println("Danh sách đơn hàng có tổng tiền > 1000 USD:");
        for (OrderTotalDTO dto : orders) {
            System.out.printf("Mã đơn hàng: %d | Tên KH: %s | Tổng tiền: %.0f USD\n",
                    dto.getOrderId(), dto.getCustomerName(), dto.getTotalAmount());
        }
    }// liệt kê đơn hàng lớn hơn 1000

    @Transactional(readOnly = true)
    public void listOrdersBuyingJavaBooks() {
        List<OrderEntity> orders = detailRepository.findOrdersByProductNameContaining("java");

        if (orders.isEmpty()) {
            System.out.println("Không có đơn hàng nào mua sách Java.");
            return;
        }

        System.out.println("Danh sách đơn hàng mua sách Java:");
        for (OrderEntity order : orders) {
            System.out.println("-----------------------------------");
            System.out.println("Mã đơn hàng: " + order.getId());
            System.out.println("Tên khách hàng: " + order.getCustomerName());
            System.out.println("Địa chỉ: " + order.getCustomerAddress());
            System.out.println("Ngày đặt: " + order.getOrderDate());

            System.out.println("Danh sách sản phẩm:");
            for (OrderDetailEntity detail : order.getOrderDetails()) {
                System.out.printf("- %s | SL: %d | Giá: %.0f\n",
                        detail.getProductName(),
                        detail.getQuantity(),
                        detail.getUnitPrice());
            }
        }
    }//Liệt kê tất cả các đơn hàng mua sách Java.

}
