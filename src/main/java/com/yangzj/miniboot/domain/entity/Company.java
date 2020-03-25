package com.yangzj.miniboot.domain.entity;

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
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String companyName;
    private String description;

    public Company(String name, String description) {
        this.companyName = name;
        this.description = description;
    }
}