
import com.lagou.entity.Course;
import com.lagou.entity.User;
import com.lagou.entity.UserCourseOrder;
import com.lagou.mapper.CourseDao;
import com.lagou.mapper.OrdeDao;
import com.lagou.mapper.UserDao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort.Order;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.UUID;

/**
 * @BelongsProject: lagou-edu
 * @Author: GuoAn.Sun
 * @CreateTime: 2020-09-07 17:59
 * @Description:
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/spring-dao.xml" })
public class TestUser {

    @Autowired
    private UserDao userDao;

    @Autowired
    private CourseDao courseDao;

    @Autowired
    private OrdeDao ordeDao;

    
    @Test
    public void login(){
//        User user = userDao.login("110", "123");
//        System.out.println("user = " + user);
    }


    @Test
    public void checkPhone(){
//        Integer i = userDao.checkPhone("1101");
//       System.out.println("i = " + i); //0：未注册 ， 1：已注册
    }

    @Test
    public void register(){
//         Integer i = userDao.register("114", "123");
//        System.out.println("i = " + i); //0：注册失败 ， 1：注册成功
    }


    @Test
    public void getAllCourse(){

//        List<Course> allCourse = courseDao.getAllCourse();
//        System.out.println(allCourse);


    }


    @Test
    public void getCourseByUserId(){
//
//        List<Course> allCourse = courseDao.getCourseByUserId("100030018");
//        System.out.println(allCourse);


    }
    @Test
    public void getCourseById(){

//        List<Course> allCourse = courseDao.getCourseById(7);
//        System.out.println(allCourse);


    }

//    #{orderNo},#{userId},#{courseId},#{activityCourseId},#{sourceType},sysdate(),sysdate(),0

    @Test
    public void saveOrde(){

        String orderNo= UUID.randomUUID().toString();
        String user_id = "100030011";
        String course_id = "7";
        String activity_course_id = "0"; // 0表示，本课程没有活动
        String source_type = "1";

        /*String orderNo= UUID.randomUUID().toString();//订单
        String userId="100030016";//用户Id
        String courseId="7";//课程id
        String activityCourseId="0";//是否是活动Id
        String sourceType="1";//订单来源*/

//  ordeDao.saveOrde(orderNo,user_id,course_id,activity_course_id,source_type);





    }

    @Test
    public void updateOrder(){
    //    Integer integer = ordeDao.updateOrder("99bb4097-c3b1-46d4-89d0-2341f9f99a5a", 20);
//        System.out.println(integer);
//        Integer integer = ordeDao.deleteOrder("99bb4097-c3b1-46d4-89d0-2341f9f99a5a");
//        System.out.println(integer);

//        List<UserCourseOrder> ordersByUserId = ordeDao.getOrdersByUserId("100030018");
//        System.out.println(ordersByUserId);


    }





}
