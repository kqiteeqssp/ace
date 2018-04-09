package com.info.controller.system;

import com.info.model.User;
import com.info.service.UserService;
import com.info.utils.EncryptUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: kqiteeq
 * @Description:
 * @Date:Created in 2018/1/19 9:59
 */
@Controller
public class LoginController {
    @Autowired
    private UserService userService;
    @RequestMapping("/")
    public String home() {

        return "/user/login";
    }
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> login(HttpServletRequest request,HttpServletResponse response, RedirectAttributes rediect, HttpSession session) throws IOException {
        Map<String, Object> map = new HashMap<String, Object>();
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        User user = userService.findByUserName(userName);
        // LOGGER.debug("程序执行的时候输出Log日志...");
        if (null == user) {
            map.put("success", false);
            map.put("message", "该用户不存在");
            return map;
        }
        if (!StringUtils.equals(EncryptUtils.encryptMD5(password), user.getPassword())) {
            map.put("success", false);
            map.put("message", "密码错误");
            return map;
        }

        // 设置session
        map.put("success", true);
        map.put("message", "登录成功");
        // 设置session
        session.setAttribute("loginName", userName);
        String sessionId = session.getId();
        if (session.isNew()) {
            response.getWriter().print("session创建成功，session的id是："+sessionId);
        }else {
            response.getWriter().print("服务器已经存在该session了，session的id是："+sessionId);
            response.reset();
        }
        return map;

    }

    @RequestMapping("/home")
    public String home(ModelMap map) {

        return "/user/index";
    }

    @RequestMapping("/signOut")
    public String signOut(ModelMap map) {

        return "/user/login";
    }
}