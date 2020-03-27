package com.yangzj.miniboot.just4test;

import com.yangzj.miniboot.domain.entity.School;
import org.apache.commons.lang3.SerializationUtils;
import org.springframework.beans.BeanUtils;


/**
 * description:
 *
 * @author yangzj
 * @date 2020/03/27
 */
public class CopyTest2 {


    public static void main(String[] args) {

        School s1 = new School();
        s1.setId(1L);
        s1.setName("school111");
        s1.setDescription("xxx");

        Student sa = new Student();
        sa.setName("aaa");
        sa.setStuNo(111);
        sa.setSchool(s1);

        Student sb = new Student();
        BeanUtils.copyProperties(sa, sb);

        sb = SerializationUtils.clone(sa);

        System.out.println(sa);
        System.out.println(sb);

        sa.setName("bbb");
        System.out.println(sa);
        System.out.println(sb);

        s1.setName("school222");
        System.out.println(sa);
        System.out.println(sb);


    }


}
