package com.ikm.test;

import java.util.Arrays;

import com.ikm.xmanager.commons.utils.Charsets;
import org.springframework.util.Base64Utils;


public class Base64Test {

    /**
     * Shiro 记住密码采用的是AES加密，AES key length 需要是16位，该方法生成16位的key
     */
    public static void main(String[] args) {
        String keyStr = "如梦技术";
        
        byte[] keys = keyStr.getBytes(Charsets.UTF_8);
        
        System.out.println(Base64Utils.encodeToString(Arrays.copyOf(keys, 16)));
    }

}
