package com.yangzj.miniboot.controller;

import com.yangzj.miniboot.domain.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolation;
import javax.validation.Valid;
import javax.validation.Validator;
import javax.validation.constraints.Max;
import javax.validation.constraints.Size;
import java.util.Set;

/**
 * description:
 *
 * @author yangzj
 * @date 2020/03/28
 */
@RestController
@RequestMapping("valid")
@Validated
public class PersonController {

    @Autowired
    Validator validator;

    @PostMapping("person")
    public ResponseEntity<Person> getPerson(@RequestBody @Valid Person person) {

        /*postman json case: 请求体映射之后的对象验证
        {
            "name":"zhangsan",
            "age":150,
            "schoolId":111,
            "companyId":111,
            "gender":"man",
            "email":"xxx@123.com",
            "region":"China-Taiwan"
        }*/

        // @valid验证失败将返回 方法验证无效异常！MethodArgumentNotValidException
        return ResponseEntity.ok(person);
    }

    @GetMapping("/person/{id}")
    public ResponseEntity<Integer> getPersonByID(@Valid @PathVariable("id") @Max(value = 5,message = "超过 id 的范围了") Integer id) {
        return ResponseEntity.ok().body(id);
    }

    @PutMapping("/person/name")
    public ResponseEntity<String> updatePersonByName(@Valid @RequestParam("name") @Size(max = 6,message = "超过 name 的范围了") String name) {
        return ResponseEntity.ok().body(name);
    }

    @PostMapping("hand")
    public ResponseEntity<String> validByHand(@RequestBody Person person) {
        Set<ConstraintViolation<Person>> violations = validator.validate(person);
        StringBuilder message = new StringBuilder();
        for (ConstraintViolation<Person> constraintViolation : violations) {
            message.append(constraintViolation.getMessage());
        }
        return ResponseEntity.ok().body(message.toString());
    }

}
