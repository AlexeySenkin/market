package ru.senkin.market.core.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;
import ru.senkin.market.core.entities.Category;
import ru.senkin.market.core.repositories.CategoryRepository;


import java.util.Collections;
import java.util.List;

@DataJpaTest
@ActiveProfiles("test")
public class CategoryRepositoryTest {
    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void findAllCategoriesTest() {
        Category category = new Category();
        category.setTitle("Electronic");
        category.setProducts(Collections.emptyList());
        entityManager.persist(category);
        entityManager.flush();

        List<Category> categoriesList = categoryRepository.findAll();
        Assertions.assertEquals(3, categoriesList.size());
        Assertions.assertEquals("Food", categoriesList.get(0).getTitle());
    }
}
