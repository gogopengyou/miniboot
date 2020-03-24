package com.yangzj.miniboot.domain.entity;

import lombok.Data;

/**
 * description: book entity.
 *
 * @author yangzj
 * @date 2020/03/23
 */
@Data
public class Book {
    private String name;

    private String description;

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
