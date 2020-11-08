package com.fsy.controlstrategy.shiro;

import cn.hutool.core.bean.BeanUtil;
import com.fsy.controlstrategy.entity.ControlUser;
import com.fsy.controlstrategy.mapper.ControlUserMapper;
import com.fsy.controlstrategy.util.JwtUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AccountRealm extends AuthorizingRealm {
    private Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    JwtUtils jwtUtils;

    @Autowired
    private ControlUserMapper controlUserMapper;

    /**
     * 这个重写方法的作用是校验用户的权限
     * （这里没有使用这种方法来校验用户权限）
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    /**
     * 用户的身份认证（shiro 源码讲解可见 ：https://www.jianshu.com/p/54dce333ecfd）
     * 这里只是拿到凭证，对比shiro会帮我们完成
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        JwtToken jwt = (JwtToken) token;
        log.info("jwt----------------->{}", jwt);
        String userId = jwtUtils.getClaimByToken((String) jwt.getPrincipal()).getSubject();
        ControlUser user = controlUserMapper.selectUserById(NumberUtils.toLong(userId));
        if(user == null) {
            throw new UnknownAccountException("账户不存在！");
        }
        if(user.getStatus() == -1) {
            throw new LockedAccountException("账户已被锁定！");
        }
        AccountProfile profile = new AccountProfile();
        BeanUtil.copyProperties(user, profile);
        log.info("profile----------------->{}", profile.toString());
        return new SimpleAuthenticationInfo(profile, jwt.getCredentials(), getName());

    }
}
