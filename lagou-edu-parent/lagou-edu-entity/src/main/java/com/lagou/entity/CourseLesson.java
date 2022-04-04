package com.lagou.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;
import java.io.Serializable;

/**
 * 课程节内容(CourseLesson)实体类
 *
 * @author LaoSun
 * @since 2020-09-08 15:19:15
 */


public class CourseLesson implements Serializable {

    private CourseMedia courseMedia; // 一小节课对应一个视频

    private static final long serialVersionUID = 753365067980240096L;
    /**
    * id
    */
    private Object id;
    /**
    * 课程id
    */
    private Integer courseId;
    /**
    * 章节id
    */
    private Integer sectionId;
    /**
    * 课时主题
    */
    private String theme;
    /**
    * 课时时长(分钟)
    */
    private Integer duration;
    /**
    * 是否免费
    */
    private Object isFree;
    /**
    * 记录创建时间
    */
    private Date createTime;
    /**
    * 更新时间
    */
    private Date updateTime;
    /**
    * 是否删除
    */
    private Object isDel;
    /**
    * 排序字段
    */
    private Integer orderNum;
    /**
    * 课时状态,0-隐藏，1-未发布，2-已发布
    */
    private Integer status;

    @Override
    public String toString() {
        return "CourseLesson{" +
                "courseMedia=" + courseMedia +
                ", id=" + id +
                ", courseId=" + courseId +
                ", sectionId=" + sectionId +
                ", theme='" + theme + '\'' +
                ", duration=" + duration +
                ", isFree=" + isFree +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", isDel=" + isDel +
                ", orderNum=" + orderNum +
                ", status=" + status +
                '}';
    }

    public CourseMedia getCourseMedia() {
        return courseMedia;
    }

    public void setCourseMedia(CourseMedia courseMedia) {
        this.courseMedia = courseMedia;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Object getId() {
        return id;
    }

    public void setId(Object id) {
        this.id = id;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public Integer getSectionId() {
        return sectionId;
    }

    public void setSectionId(Integer sectionId) {
        this.sectionId = sectionId;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Object getIsFree() {
        return isFree;
    }

    public void setIsFree(Object isFree) {
        this.isFree = isFree;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Object getIsDel() {
        return isDel;
    }

    public void setIsDel(Object isDel) {
        this.isDel = isDel;
    }

    public Integer getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}