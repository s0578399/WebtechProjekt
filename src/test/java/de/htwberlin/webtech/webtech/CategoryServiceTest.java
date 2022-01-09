package de.htwberlin.webtech.webtech;


import de.htwberlin.webtech.webtech.persistence.CategoryEntity;
import de.htwberlin.webtech.webtech.persistence.CategoryRepository;
import de.htwberlin.webtech.webtech.service.CategoryService;
import de.htwberlin.webtech.webtech.web.api.Category;
import de.htwberlin.webtech.webtech.web.api.CategoryManipulationRequest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doReturn;

@SpringBootTest
public class CategoryServiceTest {


    @Autowired
    CategoryService categoryService;

    @MockBean
    CategoryRepository categoryRepository;


    @Test
    @DisplayName("should find all categories")
    void findAllTest() {
        List<CategoryEntity> cel = new ArrayList<>();
        CategoryEntity ce1 = new CategoryEntity("Pflanzen");
        CategoryEntity ce2 = new CategoryEntity("Blumen");
        CategoryEntity ce3 = new CategoryEntity("Bäume");
        cel.add(ce1); cel.add(ce2); cel.add(ce3);
        List<Category> cl = new ArrayList<>();
        Category c1 = new Category(1L, "Pflanzen");
        Category c2 = new Category(2L, "Blumen");
        Category c3 = new Category(3L, "Bäume");
        cl.add(c1); cl.add(c2); cl.add(c3);

        doReturn(cel).when(categoryRepository).findAll();
        var actual = categoryService.findAll();

        assertEquals(cl.get(0).getCategoryName(), actual.get(0).getCategoryName());
        assertEquals(cl.get(1).getCategoryName(), actual.get(1).getCategoryName());
        assertEquals(cl.get(2).getCategoryName(), actual.get(2).getCategoryName());
    }

    @Test
    @DisplayName("should find a category by its id")
    void findByIdTest() {
        Category c = new Category(1L, "Pflanzen");
        CategoryEntity ce = new CategoryEntity("Pflanzen");
        doReturn(Optional.of(ce)).when(categoryRepository).findById(1L);
        var actual = categoryService.findById(1L);

        assertEquals(c.getCategoryName(), actual.getCategoryName());
    }

    @Test
    @DisplayName("")
    void createTest() {
        Category c = new Category(1L, "Pflanzen");
        CategoryEntity ce = new CategoryEntity("Pflanzen");
        CategoryManipulationRequest cm = new CategoryManipulationRequest("Pflanzen");

        doReturn(ce).when(categoryRepository).save(ce);

        var actual = categoryService.create(cm);

        assertEquals(c.getCategoryName(), actual.getCategoryName());

    }

    @Test
    @DisplayName("should update a category by its id")
    void updateTest() {
        Category c = new Category(1L, "Pflanzen");
        CategoryEntity ce = new CategoryEntity("Pflanzen");
        CategoryManipulationRequest cm = new CategoryManipulationRequest("Pflanzen");

        doReturn(Optional.of(ce)).when(categoryRepository).findById(1L);
        doReturn(ce).when(categoryRepository).save(ce);

        var actual = categoryService.update(1L, cm);

        assertEquals(c.getCategoryName(), actual.getCategoryName());
    }

    @Test
    @DisplayName("should delete a category by its id")
    void deleteByIdTest() {
        doReturn(true).when(categoryRepository).existsById(1L);

        var actual = categoryService.deleteById(1L);

        assertEquals(true, actual);
    }
}
