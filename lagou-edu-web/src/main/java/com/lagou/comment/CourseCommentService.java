package com.lagou.comment;

import com.lagou.entity.CourseComment;

import java.util.List;

public interface CourseCommentService {


    /*** 保存留言
     *  * @param comment留言内容对象
     *  * @return 受影响的行数 */
    public   Integer   saveComment(CourseComment courseComment);


    /**
     * 分液查询评论列表
     * @param courseid 课程id
     * @param pageIndex 页码
     * @param pageSize 每页展示多少条？
     * @return
     */
    public List<CourseComment> getCourseCommentList(Integer courseid, Integer pageIndex, Integer pageSize);

    /**
     * 点赞
     * @param comment_id 留言编号
     * @param userid 用户编号
     * @return 0：保存失败，1：保存成功
     */
    Integer saveFavorite(Integer comment_id,Integer userid);

    /**
     * 取消赞
     * @param comment_id 留言编号
     * @param userid 用户编号
     * @return 0：保存失败，1：保存成功
     */
    Integer cancelFavorite(Integer comment_id,Integer userid);


}
