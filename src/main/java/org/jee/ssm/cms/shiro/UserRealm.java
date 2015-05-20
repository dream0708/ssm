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
		 //交给AuthenticatingRealm使用CredentialsMatcher进行密码匹配，如果觉得人家的不好可以自定义实现
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                "admin", //用户名
                "d3c59d25033dbf980d29554025c23a75", //密码
                ByteSource.Util.bytes("admin8d78869f470951332959580424d4bf4f"),//salt=username+salt
                getName()  //realm name
        );
        return authenticationInfo;
	}
	
	@Override
    public void clearCachedAuthorizationInfo(PrincipalCollection principals) {
        super.clearCachedAuthorizationInfo(principals);
    }

    @Override
    public void clearCachedAuthenticationInfo(PrincipalCollection principals) {
        super.clearCachedAuthenticationInfo(principals);
    }

    @Override
    public void clearCache(PrincipalCollection principals) {
        super.clearCache(principals);
    }

    public void clearAllCachedAuthorizationInfo() {
        getAuthorizationCache().clear();
    }

    public void clearAllCachedAuthenticationInfo() {
        getAuthenticationCache().clear();
    }

    public void clearAllCache() {
        clearAllCachedAuthenticationInfo();
        clearAllCachedAuthorizationInfo();
    }


}
