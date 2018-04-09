package com.info.controller.system;

import com.info.model.User;
import com.info.service.UserService;
import com.info.utils.EncryptUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: kqiteeq
 * @Description:
 * @Date:Created in 2018/1/19 9:59
 */
@Controller
public class RegistController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/regist", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> regist(HttpServletRequest request, RedirectAttributes rediect, HttpSession session) {
        Map<String, Object> map = new HashMap<String, Object>();
        User user = new User();
        String mail = request.getParameter("mail");
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        String cpassword = request.getParameter("cpassword");

        User name = userService.findByUserName(userName);
        // LOGGER.debug("程序执行的时候输出Log日志...");
        if (null != name) {
            map.put("success", false);
            map.put("message", "该用户已存在");
            return map;
        }
        user.setEmail(mail);
        user.setUsername(userName);
        user.setPassword(EncryptUtils.encryptMD5(password));
        userService.registUser(user);


        map.put("success", true);
        map.put("message", "注册成功");
        return map;

    }

}