package com.lagou.course.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.lagou.course.CourseService;
import com.lagou.entity.Course;
import com.lagou.entity.CourseSection;
import com.lagou.mapper.CourseDao;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @program: lagou-edu-parent
 * @description: 课程实现类
 * @author: hello.xaioyu
 * @create: 2022-04-04 17:25
 **/
@Service//暴露服务
public class CourseServiceImpl implements CourseService {
    @Autowired
    private CourseDao courseDao;

    //查询所有的课程
    @Override
    public List<Course> getAllCourse() {
        return courseDao.getAllCourse();
    }

    //根据用户id来查询用户已经购买的课程信息
    @Override
    public List<Course> getCourseByUserId(String userId) {
        return courseDao.getCourseByUserId(userId);
    }

    /**
     *
     * @param courseId 课程id
     * @return 根据课程id查询课程详细
     */
    @Override
    public List<Course> getCourseById(Integer courseId) {
        return courseDao.getCourseById(courseId);
    }
}
