package de.htwberlin.webtech.webtech.persistence;

import javax.persistence.*;

@Entity(name = "categories")
public class CategoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "category_name", nullable = false)
    private String categoryName;


    public CategoryEntity(String categoryName) {
        this.categoryName = categoryName;

    }

    protected CategoryEntity() {}

    public long getId() {
        return id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}
