package com.lagou.comment;

import com.lagou.entity.CourseComment;
import org.apache.ibatis.annotations.Param;

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
    public List<CourseComment> getCourseCommentList(Integer courseid,Integer pageIndex,Integer pageSize);

}
