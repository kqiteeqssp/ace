package mail;

import com.info.service.email.EmailService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author: kqiteeq
 * @Description:
 * @Date:Created in 2018/9/30 15:56
 */

public class MailTest {
    @Autowired
    private EmailService emailService;

    @Test
    public void sendSimpleMail() throws Exception {
        emailService.sendSimpleEmail("913665661@qq.com", "this is simple mail", " hello mail");
    }


}