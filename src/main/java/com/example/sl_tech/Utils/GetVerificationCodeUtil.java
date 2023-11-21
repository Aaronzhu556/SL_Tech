package com.example.sl_tech.Utils;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;

public class GetVerificationCodeUtil {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public static String getVerificationCode(){
        Random random = new Random();
        String result="";
        for (int i=0;i<6;i++)
            result+=random.nextInt(10);

        return result;

    }
}
