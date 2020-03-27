package com.yangzj.miniboot.just4test;

import com.yangzj.miniboot.domain.entity.School;
import lombok.Data;

import java.io.Serializable;

/**
 * description:
 *
 * @author yangzj
 * @date 2020/03/27
 */
@Data
public class StudentDTO  implements Serializable {

    private String name;

    private School school;

}
