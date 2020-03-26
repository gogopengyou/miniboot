package com.yangzj.miniboot.domain.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * description:
 *
 * @author yangzj
 * @date 2020/03/26
 */
@Entity
@Data
public class Money {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private int basic;
    private int reward;
    private int punishment;
}
