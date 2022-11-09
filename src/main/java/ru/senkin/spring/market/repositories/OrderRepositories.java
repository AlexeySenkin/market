package ru.senkin.spring.market.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.senkin.spring.market.entities.Order;
import ru.senkin.spring.market.entities.User;

import java.util.Optional;

@Repository
public interface OrderRepositories  extends JpaRepository<Order, Long> {
    Optional<Order> findByUser(User user);
}
