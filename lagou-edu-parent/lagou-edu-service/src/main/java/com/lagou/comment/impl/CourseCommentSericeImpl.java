package com.lagou.comment.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.lagou.comment.CourseCommentService;
import com.lagou.entity.CourseComment;
import com.lagou.mapper.CourseCommentDao;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @program: lagou-edu-parent
 * @description: 评论区捏
 * @author: hello.xaioyu
 * @create: 2022-04-05 21:24
 **/
@Service
public class CourseCommentSericeImpl  implements CourseCommentService {
  @Autowired
  private CourseCommentDao courseCommentDao;



    /**
     *
     * @param courseComment 要存的留言参数
     * @return返回改变的行数
     */
    @Override
    public Integer saveComment(CourseComment courseComment) {
        return courseCommentDao.saveComment(courseComment);
    }

  /**
   * 分液查询评论列表
   * @param courseid 课程id
   * @param pageIndex 页码
   * @param pageSize 每页展示多少条？
   * @return
   */
  @Override
  public List<CourseComment> getCourseCommentList(Integer courseid, Integer pageIndex, Integer pageSize) {
    return courseCommentDao.getCourseCommentList(courseid, pageIndex, pageSize);
  }
}
