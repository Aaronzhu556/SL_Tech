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
    public Integer userLogin(UserDTO userDTO) {
        Integer code  = 0;
        String valueByKey = (String) redisUtil.getValueByKey(userDTO.getUser_email());
        if (valueByKey.equals(userDTO.getUser_code())){ //验证码正确
            User user = userMapper.getUserByEmail(userDTO.getUser_email());
            if (user!=null) {
                if (user.getUser_password().equals(userDTO.getUser_password())){
                    //密码正确，登录成功
                    code=200;
                }
                else code=201; //密码错误
            }
            else code=202;//用户不存在
        }else code=203;//验证码不正确

        return  code;

    }
}
