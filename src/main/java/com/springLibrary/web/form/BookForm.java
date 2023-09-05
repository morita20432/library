package com.springLibrary.web.form;

import com.springLibrary.persistence.entitiy.Book;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

public record BookForm(
        @NotNull
        @Range(min = 0, max = 200)
        Integer id,

        @NotBlank
        @Length(min = 1, max = 50)
        String name,

        @NotNull
        @Range(min = 0, max = 200)
        Integer price) {

        public Book convertToEntity() {
                return new Book(id,name,price);
        }
}
