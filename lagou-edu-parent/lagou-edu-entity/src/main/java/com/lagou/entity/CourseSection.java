package com.lagou.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;
import java.io.Serializable;
import java.util.List;

/**
 * 课程章节表(CourseSection)实体类
 *
 * @author LaoSun
 * @since 2020-09-08 15:19:20
 */

public class CourseSection implements Serializable {

    public List<CourseLesson> courseLessons; // 一章对应多个小节

    private static final long serialVersionUID = -27927452337172294L;
    /**
    * id
    */
    private Object id;
    /**
    * 课程id
    */
    private Integer courseId;
    /**
    * 章节名
    */
    private String sectionName;
    /**
    * 章节描述
    */
    private String description;
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
    private Object isDe;
    /**
    * 排序字段
    */
    private Integer orderNum;
    /**
    * 状态，0:隐藏；1：待更新；2：已发布
    */
    private Integer status;

    @Override
    public String toString() {
        return "CourseSection{" +
                "courseLessons=" + courseLessons +
                ", id=" + id +
                ", courseId=" + courseId +
                ", sectionName='" + sectionName + '\'' +
                ", description='" + description + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", isDe=" + isDe +
                ", orderNum=" + orderNum +
                ", status=" + status +
                '}';
    }

    public List<CourseLesson> getCourseLessons() {
        return courseLessons;
    }

    public void setCourseLessons(List<CourseLesson> courseLessons) {
        this.courseLessons = courseLessons;
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

    public String getSectionName() {
        return sectionName;
    }

    public void setSectionName(String sectionName) {
        this.sectionName = sectionName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public Object getIsDe() {
        return isDe;
    }

    public void setIsDe(Object isDe) {
        this.isDe = isDe;
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