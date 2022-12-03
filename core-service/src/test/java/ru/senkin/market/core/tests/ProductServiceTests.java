package ru.senkin.market.core.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import ru.senkin.marker.api.dto.ProductDto;
import ru.senkin.market.core.entities.Category;
import ru.senkin.market.core.repositories.ProductRepository;
import ru.senkin.market.core.services.CategoryService;
import ru.senkin.market.core.services.ProductService;


import java.math.BigDecimal;
import java.util.Collections;
import java.util.Optional;

@SpringBootTest(classes = ProductService.class)
public class ProductServiceTests {
    @Autowired
    private ProductService productService;

    @MockBean
    private ProductRepository productRepository;

    @MockBean
    private CategoryService categoryService;

    @Test
    public void createNewProductTest() {
        Category category = new Category();
        category.setId(1L);
        category.setTitle("Еда");
        category.setProducts(Collections.emptyList());
        Mockito.doReturn(Optional.of(category))
                .when(categoryService)
                .findByTitle("Еда");

        ProductDto productDto = new ProductDto(null, "Апельсины", BigDecimal.valueOf(100.0), "Food");

        productService.createNewProduct(productDto);

        Mockito.verify(productRepository, Mockito.times(1)).save(ArgumentMatchers.any());
    }
}
