import com.lagou.entity.User;
import com.lagou.mapper.UserDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @program: lagou-edu-parent
 * @description: 测试1
 * @author: hello.xaioyu
 * @create: 2022-04-02 23:09
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/spring-dao.xml"})
public class test1 {
   @Autowired
   private UserDao  userDao;


   @Test
   public void login(){


       User login = userDao.login("110", "123");
       System.out.println(login);

   }



}
