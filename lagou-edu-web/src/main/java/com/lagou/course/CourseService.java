package com.lagou.course;

import com.lagou.entity.Course;

import java.util.List;

public interface CourseService {

    //查询所有课程
    public List<Course> getAllCourse();

    //根据用户的id来查询用户是否买了课程捏
    public List<Course> getCourseByUserId(String userId);


    //根据课程id查询课程信息
    public List<Course> getCourseById(Integer courseId);



}
