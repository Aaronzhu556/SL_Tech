package com.example.sl_tech.Response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MyResponse {
    private String res_code;
    private String res_msg;
    private Object res_object;

}
