package ru.senkin.market.core.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.senkin.marker.api.dto.ProductDto;
import ru.senkin.marker.api.dto.ResourceNotFoundException;
import ru.senkin.market.core.entities.Category;
import ru.senkin.market.core.entities.Product;
import ru.senkin.market.core.repositories.CategoryRepository;
import ru.senkin.market.core.repositories.ProductRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    private final CategoryService categoryService;

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }

    public Product createNewProduct(ProductDto productDto) {
        Product product = new Product();
        product.setPrice(productDto.getPrice());
        product.setTitle(productDto.getTitle());

        String s = productDto.getCategoryTitle();

        Category category = categoryService.findByTitle(s).orElseThrow(() -> new ResourceNotFoundException("Category not found, title:" + s));

        product.setCategory(category);

        //TODO : Добавить категории товара и categoryService

        return product;
    }
}
