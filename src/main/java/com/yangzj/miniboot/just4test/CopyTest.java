package com.yangzj.miniboot.just4test;

import com.yangzj.miniboot.domain.entity.School;
import org.springframework.beans.BeanUtils;

/**
 * description:
 *
 * @author yangzj
 * @date 2020/03/27
 */
public class CopyTest {


    public static void main(String[] args) {

        School s1 = new School();
        s1.setId(1L);
        s1.setName("school111");
        s1.setDescription("xxx");

        Student sa = new Student();
        sa.setName("aaa");
        sa.setStuNo(111);
        sa.setSchool(s1);

        StudentDTO dto = new StudentDTO();
        BeanUtils.copyProperties(sa, dto);

        System.out.println(sa);
        System.out.println(dto);

        sa.setName("bbb");
        System.out.println(sa);
        System.out.println(dto);

        s1.setName("school222");
        System.out.println(sa);
        System.out.println(dto);


    }


}
