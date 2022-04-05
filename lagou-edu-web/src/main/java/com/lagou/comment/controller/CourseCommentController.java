package com.lagou.comment.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.lagou.comment.CourseCommentService;
import com.lagou.entity.CourseComment;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @program: lagou-edu-web
 * @description: 评论区捏
 * @author: hello.xaioyu
 * @create: 2022-04-05 21:29
 **/
@RestController
@RequestMapping("/course")
public class CourseCommentController {

    @Reference //远程调用服务捏
    private CourseCommentService courseCommentService;


    @RequestMapping("/comment/saveCourseComment")
    public Integer saveCourseComment() {
        CourseComment comment = new CourseComment();
        comment.setCourseId(7); // 课程编号
        comment.setSectionId(8); // 章节编号
        comment.setLessonId(10);// 小节编号
        comment.setUserId(100030011); // 用户编号
        comment.setUserName("Angier"); // 用户昵称
        comment.setParentId(0); //没有父id
        comment.setComment("very good!");// 留言内容
        comment.setType(0); // 0用户留言
        comment.setLastOperator(100030011); //最后操作的用户编号

        Integer integer = courseCommentService.saveComment(comment);


        return integer;
    }


    //    * 分液查询评论列表
    @RequestMapping("comment/getCourseCommentList/{courseid}/{pageIndex}/{pageSize}")
    public List<CourseComment> getCourseCommentList(@PathVariable("courseid") Integer courseid,
                                                    @PathVariable("pageIndex") Integer pageIndex,
                                                    @PathVariable("pageSize") Integer pageSize) {

        List<CourseComment> courseCommentList = courseCommentService.getCourseCommentList(courseid, pageIndex, pageSize);

        return courseCommentList;

    }


}
