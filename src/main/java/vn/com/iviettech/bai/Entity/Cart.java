package vn.com.iviettech.bai.Entity;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Cart {
    private Map<Long, CartItem> items = new HashMap<>();

    public void add(Product product, int quantity) {
        if (items.containsKey(product.getId())) {
            CartItem item = items.get(product.getId());
            item.setQuantity(item.getQuantity() + quantity);
        } else {
            items.put(product.getId(), new CartItem(product, quantity));
        }
    }
    public void remove(Long productId) {
        items.remove(productId);
    }


    public void empty() {
        items.clear();
    }

    public Collection<CartItem> getItems() {
        return items.values();
    }
    public double getTotalPrice() {
        return items.values().stream()
                .mapToDouble(CartItem::getTotalPrice)
                .sum();
    }
    public int count() {
        return items.values().stream().mapToInt(CartItem::getQuantity).sum();
    }
}
