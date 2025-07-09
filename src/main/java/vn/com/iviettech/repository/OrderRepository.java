package vn.com.iviettech.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.com.iviettech.entity.*;

public interface OrderRepository extends JpaRepository<Orders, Long> {}