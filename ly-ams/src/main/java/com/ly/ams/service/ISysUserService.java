package com.ly.ams.service;

import com.baomidou.mybatisplus.service.IService;
import com.ly.ams.vo.SysUser;

import java.util.Map;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author Yanghu
 * @since 2018-07-12
 */
public interface ISysUserService extends IService<SysUser> {
    int updateUser(Map<String,Object> map,SysUser sysUser);
    int insertUser(Map<String,Object> map,SysUser sysUser);
    int deleteUser(Map<String,Object> map,SysUser sysUser);
}
