package org.jee.ssm.cms.shiro;

import java.util.HashSet;
import java.util.Set;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

public class UserRealm extends AuthorizingRealm {

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(
			PrincipalCollection principals) {
		// TODO Auto-generated method stub
		System.out.println("--授权--");
		String username = (String)principals.getPrimaryPrincipal();
		SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo(); 
		
		Set<String> roles = new HashSet<String>();
		roles.add("admin");
		roles.add("manage");
		authorizationInfo.setRoles(roles);
		Set<String> pers = new HashSet<String>();
		pers.add("all");
        authorizationInfo.setStringPermissions(pers);
		return authorizationInfo;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken tokens) throws AuthenticationException {
		System.out.println("--认证--");
		// TODO Auto-generated method stub
		
		UsernamePasswordCaptchaToken token = (UsernamePasswordCaptchaToken) tokens ;
		String username = (String)token.getPrincipal();
		String captcha = (String)token.getCaptcha();
		String exitCode = (String)SecurityUtils.getSubject().getSession().getAttribute(com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY);
		if(null == captcha || exitCode == null || !exitCode.equalsIgnoreCase(captcha)){
			throw new CaptchaException("验证码错误");
		}
		
		if(username == null || "".equals(username) || !"admin".equals(username)){
			throw new UnknownAccountException();
		}
		if(username == "lock"){
			throw new LockedAccountException(); //帐号锁定
		}
		SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(username , //username
				"45c476317eb9073f3e33a1f9f4b84250" , // password 
				getName());
		return info;
	}

}
