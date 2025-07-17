package com.Bai7_shopping_cart.repository;

import com.Bai7_shopping_cart.model.OrdersEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<OrdersEntity, Integer> {
}
