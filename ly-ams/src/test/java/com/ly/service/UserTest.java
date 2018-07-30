package com.ly.service;

import com.ly.ams.Application;
import com.ly.ams.service.ISysUserService;
import com.ly.ams.vo.SysUser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.HashMap;
import java.util.Map;

/** 
* OrderController Tester. 
* 
* @author <Authors name> 
* @since <pre>���� 17, 2018</pre> 
* @version 1.0 
*/
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
@WebAppConfiguration
public class UserTest {
    @Autowired private ISysUserService sysUserService;
    @Test
    public void testCreateOrder(){
        try {
            SysUser sysUser = new SysUser();
            sysUser.setId("1");
            sysUser.setUserDesc("22343333");
            Map<String,Object> map = new HashMap<>();
            map.put("roles","[1]");
            sysUserService.updateUser(new HashMap<>(),sysUser);
        }catch (Exception e){
            e.printStackTrace();
        }

    }
} 
