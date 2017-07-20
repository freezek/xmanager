package com.ikaimen.controller;

import com.ikaimen.controller.base.BaseController;
import com.ikm.xmanager.cms.model.User;
import com.ikm.xmanager.cms.model.vo.UserVo;
import com.ikm.xmanager.cms.service.IUserService;
import com.ikm.xmanager.commons.csrf.CsrfToken;
import com.ikm.xmanager.commons.utils.StringUtils;
import com.ikm.xmanager.jwt.JwtTokenUtil;
import com.ikm.xmanager.permission.shiro.captcha.DreamCaptcha;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.DisabledAccountException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mobile.device.Device;
import org.springframework.mobile.device.DevicePlatform;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by Tom Chen on 2017/7/20.
 * app登录控制器
 */
@Controller
@RequestMapping("/app")
public class UserLoginController extends BaseController {

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private IUserService userService;

    private UserVo userVo = null;
    /**
     * POST 登录 shiro 写法
     *
     * @param username 用户名
     * @param password 密码
     * @return {Object}
     */
    @PostMapping("/login")
    @CsrfToken(remove = true)
    @ResponseBody
    public Object loginPost(HttpServletRequest request, HttpServletResponse response,
                            String username, String password, String captcha,
                            @RequestParam(value = "rememberMe", defaultValue = "0") Integer rememberMe) {
        logger.info("POST请求登录");
        // 改为全部抛出异常，避免ajax csrf token被刷新
        if (StringUtils.isBlank(username)) {
            throw new RuntimeException("用户名不能为空");
        }
        if (StringUtils.isBlank(password)) {
            throw new RuntimeException("密码不能为空");
        }
//        if (StringUtils.isBlank(captcha)) {
//            throw new RuntimeException("验证码不能为空");
//        }
        Subject user = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        // 设置记住密码
        token.setRememberMe(1 == rememberMe);
        try {
            user.login(token);
            userVo = new UserVo();
            userVo.setLoginName(username);
            List<User> user1 = userService.selectByLoginName(userVo);
            return renderSuccess(jwtTokenUtil.generateToken(user1.get(0), new Device() {
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
            }));
        } catch (UnknownAccountException e) {
            throw new RuntimeException("账号不存在！", e);
        } catch (DisabledAccountException e) {
            throw new RuntimeException("账号未启用！", e);
        } catch (IncorrectCredentialsException e) {
            throw new RuntimeException("密码错误！", e);
        } catch (Throwable e) {
            throw new RuntimeException(e.getMessage(), e);
        }


    }
}
