package com.keboda.eomsback.jira.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.keboda.eomsback.email.pojo.EmailBody;
import com.keboda.eomsback.email.service.EmailService;
import com.keboda.eomsback.jira.mapper.UserMapper;
import com.keboda.eomsback.jira.pojo.User;
import com.keboda.eomsback.jira.service.IJiraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

import static com.keboda.eomsback.jira.service.impl.DefaultPasswordEncoder.DEFAULT_INSTANCE;

@Service
@DS("jira")
public class JiraServiceImpl implements IJiraService {

    @Resource
    private UserMapper userMapper;
    @Autowired
    private EmailService emailService;

    @Override
    @Transactional
    public String updatePassword(User user) {
        String passwd = DEFAULT_INSTANCE.encodePassword(user.getPassword());
        user.setPkcs5(passwd);
        userMapper.updatePassword(user);
        EmailBody emailBody = new EmailBody();
        emailBody.setTo(user.getEmail());
        emailBody.setSubject("用户Jira登录密码更改");
        emailBody.setText("亲爱的用户：\n你好！你的Jira登录密码已更改，新初始密码如下："+ user.getPassword() + "\n请及时更改新密码。 \n如有问题，请联系： \n颜丹青 Tel: 86-21-60978999*6541");
        emailService.itSupportSend(emailBody);
        return "密码修改成功";
    }
}
