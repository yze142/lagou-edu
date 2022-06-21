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

  /**
   *点赞：
   * 先查看当前用户对这条留言是否点过赞，
   * 如果点过：修改is_del状态即可，取消赞
   * 如果没点过：保存一条点赞的信息
   *
   * 最终，更新赞的数量
   */
  @Override
  public Integer saveFavorite(Integer comment_id, Integer userid) {
    Integer i = courseCommentDao.existsFavorite(comment_id, userid);
    int i1 = 0;
    int i2 = 0;
    if(i == 0){ //没点过赞
      i1 = courseCommentDao.saveCommentFavorite(comment_id,userid);
    }else{
      i1 = courseCommentDao.updateFavoriteStatus(0,comment_id,userid);
    }
    i2 = courseCommentDao.updateLikeCount(1,comment_id);

    if(i1==0 || i2==0){
      throw  new RuntimeException("点赞失败！");
    }
    return comment_id;
  }

  /**
   * 删除点赞的信息（is_del = 1）
   * 更新留言赞的数量-1
   * @param comment_id 留言编号
   * @param userid 用户编号
   * @return 0:失败，1：成功
   */
  @Override
  public Integer cancelFavorite(Integer comment_id, Integer userid) {
    Integer i1 = courseCommentDao.updateFavoriteStatus(1, comment_id, userid);
    Integer i2 = courseCommentDao.updateLikeCount(-1,comment_id);

    if(i1==0 || i2==0){
      throw  new RuntimeException("取消赞失败！");
    }
    return i2;
  }








}
