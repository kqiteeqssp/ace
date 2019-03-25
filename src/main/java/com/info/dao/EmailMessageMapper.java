package com.info.dao;

import com.info.model.EmailMessage;

import java.util.List;

/**
 * Created by kqiteeq on 2018/9/19.
 */
public interface EmailMessageMapper {
    List<EmailMessage> scanForSending();
    int sendSuccessfully(Long id);
}
