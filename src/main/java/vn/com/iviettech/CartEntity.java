package vn.com.iviettech;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)

public class CartEntity {
    private Map<Long, Integer> cartItems = new HashMap<>();

    public void addItem(Long productId) {
        cartItems.put(productId, cartItems.getOrDefault(productId, 0) + 1);
    }

    public void removeItem(Long productId) {
        cartItems.remove(productId);
    }

    public void updateItem(Long productId, int quantity) {
        if (quantity <= 0) removeItem(productId);
        else cartItems.put(productId, quantity);
    }

    public Map<Long, Integer> getItems() {
        return cartItems;
    }

    public void clear() {
        cartItems.clear();
    }
}

