package com.yangzj.miniboot.just4test;

import lombok.Builder;
import lombok.Data;

/**
 * description:
 *
 * @author yangzj
 * @date 2020/03/25
 */
@Data
@Builder(toBuilder = true)
public class BuilderTest {

    private String id;
    private String name;
    private boolean active;

    public static void main(String[] args) {
        BuilderTest test1 = BuilderTest.builder().id("111").name("yangzj").active(false).build();
        System.out.println(test1);

        BuilderTest test2 = new BuilderTest("111", "zhangsan", true);
        System.out.println(test2);

        test1.setActive(true);
        test2.setActive(false);
        System.out.println(test1);
        System.out.println(test2);

    }
}
