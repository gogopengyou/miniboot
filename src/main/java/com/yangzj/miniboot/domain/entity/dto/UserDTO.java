package com.yangzj.miniboot.domain.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * description:
 *
 * @author yangzj
 * @date 2020/03/25
 */
@Data
@NoArgsConstructor
@Builder(toBuilder = true)
@AllArgsConstructor
public class UserDTO {
    private String name;
    private int age;
    private String companyName;
    private String schoolName;
}
