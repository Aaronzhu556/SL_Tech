package com.example.sl_tech.Service;

import com.example.sl_tech.DTO.UserDTO;
import com.example.sl_tech.Entity.User;
import com.example.sl_tech.Mapper.UserMapper;
import com.example.sl_tech.Service.Interface.AuthService;
import com.example.sl_tech.Utils.EmailSenderUtil;
import com.example.sl_tech.Utils.GetVerificationCodeUtil;
import com.example.sl_tech.Utils.RedisUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {
    @Autowired
    private EmailSenderUtil emailSenderUtil;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RedisUtil redisUtil;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Override
    public String getCaptcha(String user_email) {
        String verificationCode = GetVerificationCodeUtil.getVerificationCode();
        emailSenderUtil.sendSimpleEmail(user_email,"Login captcha","Your captcha is:"+verificationCode);
        redisUtil.setValue(user_email,verificationCode,300);
        logger.info("用户的验证码是:"+verificationCode);
        return verificationCode;
    }

    @Override
    public String userLogin(UserDTO userDTO) {
        String valueByKey = (String) redisUtil.getValueByKey(userDTO.getUser_email());
        if (valueByKey.equals(userDTO.getUser_code())){ //验证码正确
            User user = userMapper.getUserByEmail(userDTO.getUser_email());
        }



        return null;
    }
}
