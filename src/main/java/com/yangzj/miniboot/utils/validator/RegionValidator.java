package com.yangzj.miniboot.utils.validator;

import com.yangzj.miniboot.utils.validator.annotation.Region;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.HashSet;

/**
 * description:自定义验证逻辑，return boolean。
 *
 * @author yangzj
 * @date 2020/03/28
 */
public class RegionValidator implements ConstraintValidator<Region, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        HashSet<Object> regions = new HashSet<>();
        regions.add("China");
        regions.add("China-Taiwan");
        regions.add("China-HongKong");
        return regions.contains(value);
    }
}