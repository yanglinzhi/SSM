package com.ylz.spring.test;


import com.ylz.spring.pojo.Course;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

//指定当前测试类在spring的测试环境中执行，此时可通过注入的方式直接获取ioc容器的bean
@RunWith(SpringJUnit4ClassRunner.class)
//用来设置spring设置环境的配置文件
@ContextConfiguration("classpath:spring-jdbc.xml")
public class JdbcTemplateTest {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    public void testInsert(){
        String sql = "insert into course values(null,?,?)";
        jdbcTemplate.update(sql,"小明","123456");
    }
    @Test
    public void testGetById(){
        String sql = "select * from course where c_id = ?";
        Course course = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Course.class), 1);
        System.out.println(course);
    }
    @Test
    public void testGetAllCourse(){
        String sql = "select * from course";
        List<Course> query = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Course.class));
        query.forEach(System.out::println);
    }
    @Test
    public void testGetCount(){
        String sql = "select count(*) from course";
        Integer count = jdbcTemplate.queryForObject(sql, Integer.class);
        System.out.println(count);

    }
}
