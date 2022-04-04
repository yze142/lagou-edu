package com.lagou.course.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.lagou.course.CourseService;
import com.lagou.entity.Course;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @program: lagou-edu-web
 * @description: 课程
 * @author: hello.xaioyu
 * @create: 2022-04-04 17:30
 **/
@RestController
@RequestMapping("/course")
public class CourseController {

    @Reference //远程消费类
    private CourseService courseService;


    @RequestMapping("/getAllCourse")
    public List<Course> getAllCourse() {

        List<Course> allCourse = courseService.getAllCourse();

        return allCourse;
    }

    @RequestMapping("getCourseByUserId/{userid}")
    public List<Course> getCourseByUserId(@PathVariable("userid") String userid){


             return courseService.getCourseByUserId(userid);


    }

    @RequestMapping("/getCourseById/{courseid}")
    public List<Course> getCourseById(@PathVariable("courseid")Integer courseid){

        return courseService.getCourseById(courseid);

    }





}
