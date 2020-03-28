package com.yangzj.miniboot.domain.entity;

import com.yangzj.miniboot.utils.validator.annotation.Region;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.*;

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
    @NotNull(message = "name不能为空")
    private String name;

    @Max(120)
    @Min(18)
    private Integer age;

    @NotNull(message = "companyId不能为空")
    private Long companyId;

    @NotNull(message = "schoolId不能为空")
    private Long schoolId;

    @Pattern(regexp = "((^man$|^women$))", message = "性别须知可选范围")
    private String gender;

    @Email(message = "email格式不正确")
    @NotNull(message = "email不能为空")
    private String email;

    @NotNull
    @Region
    private String region;

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

}
