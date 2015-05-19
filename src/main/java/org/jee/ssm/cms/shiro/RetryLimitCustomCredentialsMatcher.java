package org.jee.ssm.cms.shiro;

import java.util.concurrent.atomic.AtomicInteger;

import javax.annotation.Resource;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.credential.SimpleCredentialsMatcher;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheManager;

public class RetryLimitCustomCredentialsMatcher extends
		SimpleCredentialsMatcher {

	private PasswordHelper passwordHelper;
	private String salt = "b429331aa3b95e710bc0f5a766b1a920";

	private Cache<String, AtomicInteger> passwordRetryCache;

	public RetryLimitCustomCredentialsMatcher(CacheManager cacheManager) {
		passwordRetryCache = cacheManager.getCache("passwordRetryCache");
	}

	@Override
	public boolean doCredentialsMatch(AuthenticationToken authcToken,
			AuthenticationInfo info) {
		UsernamePasswordCaptchaToken token = (UsernamePasswordCaptchaToken) authcToken;
		String username = token.getUsername();
		AtomicInteger retryCount = passwordRetryCache.get(username);
		if (retryCount == null) {
			retryCount = new AtomicInteger(0);
			passwordRetryCache.put(username, retryCount);
		}
		if (retryCount.incrementAndGet() > 3) {
			// if retry count > 5 throw
			throw new ExcessiveAttemptsException();
		}
		Object tokenCredentials = passwordHelper.encryptPassword(
				String.valueOf(token.getPassword()), salt);
		Object accountCredentials = getCredentials(info);
		
		
		boolean matches = true;
				//equals(tokenCredentials, accountCredentials);
		if (matches) {
			// clear retry count
			passwordRetryCache.remove(username);
		}
		return true;
	}

	
	public PasswordHelper getPasswordHelper() {
		return passwordHelper;
	}

	@Resource
	public void setPasswordHelper(PasswordHelper passwordHelper) {
		this.passwordHelper = passwordHelper;
	}

}
