package com.info.application;

import com.info.model.User;
import com.info.service.UserService;
import com.info.service.email.EmailService;
import com.info.utils.ClassUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Author: kqiteeq
 * @Description:
 * @Date:Created in 2018/9/18 11:11
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TestMail {
    @Autowired
    private EmailService emailService;
    @Autowired
    private UserService userService;


    /*@Test
    public void sendSimpleMail() throws Exception {
        emailService.sendSimpleEmail("913665661@qq.com", "this is simple mail", " hello mail");
    }*/
//    @Test
//    public void sendHtmlMail() throws Exception {
//        String content="<html>\n" +
//                "<body>\n" +
//                "    <h3>hello world ! 这是一封Html邮件!</h3>\n" +
//                "</body>\n" +
//                "</html>";
//        emailService.sendHtmlEmail("913665661@qq.com","this is html mail",content);
//    }
    @Test
    public void testRef() {
        List<User> userList = userService.findAll();
        List<Map> mapList = new ArrayList<Map>();
        for (User user : userList) {
            Map<String, String> stringObjectMap = ClassUtil.setConditionMap(user);
            mapList.add(stringObjectMap);

        }
        System.out.println(mapList);
    }


}