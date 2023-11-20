package com.example.sl_tech.Entity;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class User implements Serializable {
    private int user_id;
    private String user_email;
    private String user_password;

}
