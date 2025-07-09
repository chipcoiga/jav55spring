package vn.com.iviettech.cart;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class CartEntity {
    private Map<Long, Integer> items = new HashMap<>();

    public void add(Long productId) {
        items.put(productId, items.getOrDefault(productId, 0) + 1);
    }

    public void remove(Long productId) {
        items.remove(productId);
    }

    public void changeQuantity(Long productId, int quantity) {
        if (quantity <= 0) remove(productId);
        else items.put(productId, quantity);
    }

    public Map<Long, Integer> getItems() {
        return items;
    }

    public void clear() {
        items.clear();
    }
}
