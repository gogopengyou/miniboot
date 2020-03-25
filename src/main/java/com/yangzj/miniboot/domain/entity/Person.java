package com.yangzj.miniboot.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * description:
 *
 * @author yangzj
 * @date 2020/03/25
 */
@Entity
@Data
@NoArgsConstructor
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String name;
    private Integer age;
    private Long companyId;
    private Long schoolId;

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

}
