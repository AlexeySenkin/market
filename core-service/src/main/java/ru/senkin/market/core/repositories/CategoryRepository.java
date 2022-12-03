package ru.senkin.market.core.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.senkin.market.core.entities.Category;


import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

//    @Query("select c from Category c where c.title = :title")
//    Optional<Category> findByTitle(@Param("title") String title);

    Optional<Category> findByTitle(String title);

}