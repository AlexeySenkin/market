package ru.senkin.market.core.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.senkin.market.core.entities.Order;

import java.util.Optional;

@Repository
public interface OrderRepositories  extends JpaRepository<Order, Long> {
    Optional<Order> findByUsername(String username);
}
