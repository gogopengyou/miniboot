package com.yangzj.miniboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * description:
 *
 * @author yangzj
 * @date 2020/03/23
 */
@PropertySource("classpath:config/temp.yml")
@RestController
@RequestMapping("config")
public class ConfigController {

    @Value("${name}")
    private String configName;

    @Value("${date2}")
    private Date tempDate;

    @Value("${flag}")
    private Boolean flag;

    @GetMapping("get")
    public ResponseEntity get() {

        List properties = new ArrayList();

        properties.add(configName);

        LocalDateTime localDateTime = LocalDateTime.ofInstant(tempDate.toInstant(), ZoneId.systemDefault());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
        properties.add(localDateTime.format(formatter));

        properties.add(flag);

        return ResponseEntity.ok(properties);
    }

}
