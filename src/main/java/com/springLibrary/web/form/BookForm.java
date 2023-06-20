package com.springLibrary.web.form;

import com.springLibrary.persistence.entitiy.Book;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;


public class BookForm {

    @NotNull
    @Range(min = 0, max = 200)
    private Integer id;

    @NotBlank
    @Length(min = 1, max = 50)
    private String name;

    @NotNull
    @Range(min = 0, max = 200)
    private Integer price;

    @NotNull
    @Range(min = 0, max = 200)
    private Integer categoryId;

    @NotNull
    @Length(min = 1, max = 50)
    private String CategoryName;

    public Book convertToEntity() {
        return new Book(id, name, price);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return CategoryName;
    }

    public void setCategoryName(String categoryName) {
        CategoryName = categoryName;
    }
}
