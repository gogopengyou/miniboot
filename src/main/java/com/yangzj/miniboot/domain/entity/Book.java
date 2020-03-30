package com.yangzj.miniboot.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * description: book entity.
 *
 * @author yangzj
 * @date 2020/03/23
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
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
