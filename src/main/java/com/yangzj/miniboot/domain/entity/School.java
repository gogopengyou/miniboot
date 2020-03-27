package com.yangzj.miniboot.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

/**
 * description:
 *
 * @author yangzj
 * @date 2020/03/25
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class School  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String name;
    private String description;
}