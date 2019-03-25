package com.info.service.email;

/**
 * Created by kqiteeq on 2018/9/30.
 */
public interface EmailService {

    /**
     *  发送简单邮件
     */
    public void sendSimpleEmail(String to, String subject, String content);

    /**
     * 发送html格式邮件
     */
    public void sendHtmlEmail(String to, String subject, String content);
    /**
     * 发送带附件的邮件
     */
    public void sendAttachmentsEmail(String to, String subject, String content, String filePath);
    /**
     * 发送带静态资源的邮件
     */
    public void sendInlineResourceEmail(String to, String subject, String content, String rscPath, String rscId);


}
