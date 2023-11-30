package com.example.sl_tech.Service.Interface;

import com.example.sl_tech.DTO.UserDTO;
import org.springframework.stereotype.Service;

@Service
public interface AuthService {
     String getCaptcha(String user_email);
     Integer userLogin(UserDTO userDTO);
}
