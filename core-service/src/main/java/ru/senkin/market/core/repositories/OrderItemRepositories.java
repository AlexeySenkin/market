package ru.senkin.market.core.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.senkin.market.core.entities.OrderItem;

@Repository
public interface OrderItemRepositories  extends JpaRepository<OrderItem, Long> {
   // Optional<OrderRepositories> findByOrder(int orderId);
}
