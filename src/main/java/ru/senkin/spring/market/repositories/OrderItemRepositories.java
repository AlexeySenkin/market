package ru.senkin.spring.market.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.senkin.spring.market.entities.OrderItem;


import java.util.Optional;

@Repository
public interface OrderItemRepositories  extends JpaRepository<OrderItem, Long> {
   // Optional<OrderRepositories> findByOrder(int orderId);
}
