package com.example.sl_tech.Mapper;

import com.example.sl_tech.Entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    User getUserByEmail(String user_email);
}
