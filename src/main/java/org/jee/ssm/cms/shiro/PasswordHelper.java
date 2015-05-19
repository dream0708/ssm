package org.jee.ssm.cms.shiro;

import org.apache.shiro.crypto.RandomNumberGenerator;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.jee.ssm.cms.pojo.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * <p>User: dream0708@163.com
 * <p>Date: 14-1-28
 * <p>Version: 1.0
 */
@Service
public class PasswordHelper {

    private RandomNumberGenerator randomNumberGenerator = new SecureRandomNumberGenerator();

    @Value("md5")
    private String algorithmName = "md5";
    @Value("2")
    private int hashIterations = 2;

    public void setRandomNumberGenerator(RandomNumberGenerator randomNumberGenerator) {
        this.randomNumberGenerator = randomNumberGenerator;
    }

    public void setAlgorithmName(String algorithmName) {
        this.algorithmName = algorithmName;
    }

    public void setHashIterations(int hashIterations) {
        this.hashIterations = hashIterations;
    }

    public String encryptPassword(String password) {

        String salt = randomNumberGenerator.nextBytes().toHex() ;

        String newPassword = new SimpleHash(
                algorithmName,
                password ,
                salt ,
                hashIterations).toHex();

        return newPassword;
    }
    
    public String encryptPassword(String password , String salt) {

      
        String newPassword = new SimpleHash(
                algorithmName,
                password ,
                salt ,
                hashIterations).toHex();

        return newPassword;
    }
    
    
    
    public void encryptPassword(User user) {

        user.setSalt(randomNumberGenerator.nextBytes().toHex());

        String newPassword = new SimpleHash(
                algorithmName,
                user.getPassword(),
                ByteSource.Util.bytes(user.getCredentialsSalt()),
                hashIterations).toHex();

        user.setPassword(newPassword);
    }
    
    public static void main(String args[]){
    	User user = new User();
    	user.setUsername("admin");
    	user.setPassword("123");
    	PasswordHelper helper  = new PasswordHelper();
    	helper.encryptPassword(user);
    	System.out.println(user);
    }
}
