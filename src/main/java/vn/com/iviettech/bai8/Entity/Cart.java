package vn.com.iviettech.bai8.Entity;

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


    public int count() {
        return items.values().stream().mapToInt(CartItem::getQuantity).sum();
    }
}
