package com.fsy.controlstrategy.controller.login;

import com.fsy.controlstrategy.controller.base.BaseController;
import com.fsy.controlstrategy.controller.base.ResponseVo;
import com.fsy.controlstrategy.controller.param.LoginParam;
import com.fsy.controlstrategy.entity.SysUser;
import com.fsy.controlstrategy.entity.enums.ControlWebStatusEnum;
import com.fsy.controlstrategy.service.LoginService;
import com.fsy.controlstrategy.util.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@RestController
@Slf4j
public class LoginController extends BaseController {

    @Autowired
    private LoginService loginService;

    @Autowired
    private JwtUtils jwtUtils;
    /**
     *
     * @return
     */
    @RequestMapping("/login")
    public ResponseVo login (@RequestBody LoginParam loginParam, HttpServletResponse response) {
        if (StringUtils.isEmpty(loginParam) || StringUtils.isEmpty(loginParam.getUserName())) {
            return generateResponseVo(ControlWebStatusEnum.PARAM_ERROR,null);
        }

        SysUser userInfo = loginService.getUserByUserName(loginParam.getUserName());
        if (StringUtils.isEmpty(userInfo)) {
            return  generateResponseVo(ControlWebStatusEnum.USER_NO_LOGIN,null);
        }

        String jwt = jwtUtils.generateToken(userInfo.getId());
        response.setHeader("Authorization", jwt);
        response.setHeader("Access-Control-Expose-Headers", "Authorization");


        return generateResponseVo(ControlWebStatusEnum.SUCCESS, userInfo);
    }

    @GetMapping("/logout")
    @RequiresAuthentication
    public ResponseVo logout() {
        SecurityUtils.getSubject().logout();
        return generateResponseVo(ControlWebStatusEnum.SUCCESS,null);
    }
}
