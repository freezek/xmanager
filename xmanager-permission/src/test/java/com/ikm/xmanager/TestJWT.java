package com.ikm.xmanager;

import com.ikm.xmanager.cms.model.User;
import com.ikm.xmanager.jwt.JwtTokenUtil;
import com.xiaoleilu.hutool.date.DateUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mobile.device.Device;
import org.springframework.mobile.device.DevicePlatform;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

/**
 * Created by Tom Chen on 2017/7/20.
 * 测试jwt
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-config-permission.xml" })
public class TestJWT {

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Test
    public void test(){
        User user = new User();
        user.setId(1L);
        user.setLoginName("15198854094");
        user.setCreateTime(new Date());
        String jwtStr = this.getToken(user);

        System.out.println("生成的jwt字符串："+jwtStr);

        boolean isOk = jwtTokenUtil.validateToken(jwtStr,user);

        System.out.println("jwt校验是否成功："+isOk);
        System.out.println("subject 的名字是："+jwtTokenUtil.getUsernameFromToken(jwtStr));
        user.setLoginName("15812076166");
        boolean isOk1 = jwtTokenUtil.validateToken(jwtStr,user);
        String jwtStr1 = this.getToken(user);
        System.out.println("修改用户信息后，jwt校验是否成功："+isOk1);
        System.out.println("修改用户信息后，subject 的名字是："+jwtTokenUtil.getUsernameFromToken(jwtStr1));

        String jwtStr2 = jwtTokenUtil.refreshToken(jwtStr1);

        boolean isOk2 = jwtTokenUtil.validateToken(jwtStr,user);
        boolean isOk3 = jwtTokenUtil.validateToken(jwtStr2,user);
        System.out.println("刷新token后，原jwt校验是否成功："+isOk2);
        System.out.println("刷新token后，新jwt校验是否成功："+isOk3);
        System.out.println("刷新token后，subject 的名字是："+jwtTokenUtil.getUsernameFromToken(jwtStr2));

        Date date = jwtTokenUtil.getExpirationDateFromToken(jwtStr2);
        System.out.println("通过token获取过期时间："+ DateUtil.format(date,"yyyy-MM-dd HH:mm:ss"));
        Date date1 = jwtTokenUtil.getCreatedDateFromToken(jwtStr2);
        System.out.println("通过token获取创建时间："+ DateUtil.format(date1,"yyyy-MM-dd HH:mm:ss"));
    }

    private String getToken(User user){

        return jwtTokenUtil.generateToken(user, new Device() {
            @Override
            public boolean isNormal() {
                return false;
            }

            @Override
            public boolean isMobile() {
                return false;
            }

            @Override
            public boolean isTablet() {
                return false;
            }

            @Override
            public DevicePlatform getDevicePlatform() {
                return null;
            }
        });
    }
}
