package com.lagou.mapper;

import com.lagou.entity.Course;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface CourseDao {


    //查询所有课程信息
    public List<Course> getAllCourse();

    //根据用户id查询已经订购的课程
    public List<Course> getCourseByUserId(String userId);

   //根据课程id查询详细
    public List<Course> getCourseById(Integer courseId);


}
