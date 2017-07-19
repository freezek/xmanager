package com.ikaimen.token;

import com.ikaimen.model.User;
import io.jsonwebtoken.Claims;

import javax.security.auth.Subject;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Tom Chen on 2017/7/19.
 * jwt 测试类
 */
public  class Test {

    public static void main(String[] args) {

        User user = new User();

        JwtUtil jwtUtil = new JwtUtil();

        String subject = jwtUtil.generalSubject(user);

        try {
            String jwts = jwtUtil.createJWT(Constant.JWT_ID,subject,System.currentTimeMillis());

           Claims c = jwtUtil.parseJWT(jwts);
            System.out.println(c.getId());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
