package ru.senkin.market.core.tests;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;
import ru.senkin.market.core.entities.Category;


import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;

@JsonTest
public class JsonTests {
    @Autowired
    private JacksonTester<Category> jackson;

    @Test
    public void jsonSerializationTest() throws Exception {
        Category category = new Category();
        category.setId(1L);
        category.setTitle("Еда");
        category.setProducts(Collections.emptyList());
        // {
        //   "id": 1,
        //   "title": "Еда"
        //   "products": [
        //     {
        //       "id": 10,
        //       "title": "Pineapple",
        //       "price": 120.00
        //     }
        //   ]
        // }
        // $.products[0].title -> Pineapple

        assertThat(jackson.write(category))
                .hasJsonPathNumberValue("$.id")
                .extractingJsonPathStringValue("$.title").isEqualTo("Еда");
    }

    @Test
    public void jsonDeserializationTest() throws Exception {
        String content = "{\"id\": 2,\"title\":\"Food\",\"products\": []}";
        Category expectedCategory = new Category();
        expectedCategory.setId(2L);
        expectedCategory.setTitle("Food");
        expectedCategory.setProducts(Collections.emptyList());

        assertThat(jackson.parse(content)).isEqualTo(expectedCategory);
        assertThat(jackson.parseObject(content).getTitle()).isEqualTo("Food");
    }
}