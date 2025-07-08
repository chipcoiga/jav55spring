package vn.com.iviettech.bai8.Service;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;
import vn.com.iviettech.bai8.Entity.OrderDetail;
import vn.com.iviettech.bai8.Entity.Product;
import vn.com.iviettech.bai8.Repository.ProductRepo;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService
{
    private final ProductRepo productRepo;


    public ProductService(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    @PostConstruct
    public void init(){
        List<Product> products = new ArrayList<>();
        Product product1 = new Product();
        product1.setName("Mac");
        product1.setDescription("....");
        product1.setPrice(500.0);

        Product product2 = new Product();
        product2.setName("Mac");
        product2.setDescription("....");
        product2.setPrice(500.0);

        products.addAll(List.of(product1, product2));
        productRepo.saveAll(products);

    }

    public List<Product> showProduct(){
        return productRepo.findAll();
    }

    public Product addProduct(Long id, String name, String description, Double price, List<OrderDetail> orderDetails){
        Product product = new Product();
        product.setName(name);
        product.setPrice(price);
        product.setDescription(description);
        product.setOrderDetails(orderDetails);

         return productRepo.save(product);
    }

   public Product findById(Long id){
        return productRepo.findById(id).orElseThrow();
   }
}
