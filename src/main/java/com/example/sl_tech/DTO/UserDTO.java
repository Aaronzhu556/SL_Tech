package com.example.sl_tech.DTO;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDTO {
    private int user_id;
    private String user_email;
    private String user_password;
    private String user_code;
}
