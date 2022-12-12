package ru.senkin.market.core.controllers;

import com.sun.xml.bind.v2.TODO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import ru.senkin.marker.api.dto.ProductDto;
import ru.senkin.marker.api.dto.ResourceNotFoundException;
import ru.senkin.market.core.entities.Product;
import ru.senkin.market.core.services.CategoryService;
import ru.senkin.market.core.services.ProductService;

import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;
    private final CategoryService categoryService;

    @GetMapping
    public List<ProductDto> findAllProducts() {
        // TODO: categoryTitle

        return productService.findAll().stream().map(product -> new ProductDto(product.getId(), product.getTitle(), product.getPrice(), "" )).collect(Collectors.toList());
    }

//    @GetMapping("/{id}")
//    public ResponseEntity<?> findProductById(@PathVariable Long id) {
//        Optional<Product> product = productService.findById(id);
//        if (!product.isPresent()) {
//            ResponseEntity<AppError> err = new ResponseEntity<>(new AppError(HttpStatus.NOT_FOUND.value(), "Product not found, id:" + id), HttpStatus.NOT_FOUND);
//            return err;
//        }
//        return new ResponseEntity<>(product.get(), HttpStatus.OK);
//    }

    @GetMapping("/{id}")
    public ProductDto findProductById(@PathVariable Long id) {
        // TODO: categoryTitle

        Product product = productService.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product not found, id:" + id));
        return new ProductDto(product.getId(), product.getTitle(), product.getPrice(), "");
    }

    @DeleteMapping("/{id}")
    public void deleteProductById(@PathVariable Long id) {
        productService.deleteById(id);
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createNewProducts(@RequestBody ProductDto productDto) {
        productService.createNewProduct(productDto);
    }
}
