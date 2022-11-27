package ru.senkin.market.core.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.senkin.market.core.entities.Order;
import ru.senkin.market.core.entities.User;

import java.util.Optional;

@Repository
public interface OrderRepositories  extends JpaRepository<Order, Long> {
    Optional<Order> findByUser(User user);
}
