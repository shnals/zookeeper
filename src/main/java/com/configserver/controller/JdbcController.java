package com.configserver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * FileName: JdbcController
 * Author:   程序猿不是猴
 * Date:     2019/12/6 9:30
 * Description: 测试入口
 */
@Controller
@ResponseBody
public class JdbcController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GetMapping("/datasource1")
    public Object list() {
        return jdbcTemplate.queryForList("SELECT * FROM datasource1");
    }

    @GetMapping("/datasource2")
    public Object list1() {
        return jdbcTemplate.queryForList("SELECT * FROM datasource1");
    }

}