package com.yangzj.miniboot.just4test;


/**
 * idea 可以通过数据库生成 POJO
 * Generate POJOs.groovy
 * 可自行修改为～ 带 Lombok 注释的实体类
 */
public class User {

  private long id;
  private long age;
  private double money;
  private String name;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public long getAge() {
    return age;
  }

  public void setAge(long age) {
    this.age = age;
  }


  public double getMoney() {
    return money;
  }

  public void setMoney(double money) {
    this.money = money;
  }


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

}
