import domain.Users;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import service.UserService;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @program: lagou-dubbo-parent
 * @description: 测试
 * @author: hello.xaioyu
 * @create: 2022-03-25 13:45
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:spring/spring-*.xml"})
public class test {

    @Autowired
    private UserService userService;

    @Test
    public void register(){

        Users users=new Users();
        String time = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        users.setPhone("13245744");
        users.setCreatetime(time);
        users.setUsername("zzz");
        users.setPassword("adsf");



        userService.register(users);
        System.out.println("注册成功！");
    }


}
