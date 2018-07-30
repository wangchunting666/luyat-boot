package com.ly.ams.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.ly.ams.dao.SysUserMapper;
import com.ly.ams.dao.SysUserRoleMapper;
import com.ly.ams.service.ISysUserRoleService;
import com.ly.ams.service.ISysUserService;
import com.ly.ams.vo.SysUser;
import com.ly.ams.vo.SysUserRole;
import com.ly.tls.baseclass.OToString;
import com.ly.tls.throwable.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author Yanghu
 * @since 2018-07-12
 */
@Service
@Transactional
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements ISysUserService {

    @Autowired private ISysUserRoleService sysUserRoleService;

    private void updateUserRole(Map<String, Object> map,SysUser sysUser) throws Throwable{
        sysUserRoleService.delete(new EntityWrapper<SysUserRole>().where("userId = "+sysUser.getId()));
        String roles = OToString.toString(map.get("roles"));
        List<SysUserRole> list = new ArrayList<>();
        for(String s:roles.split(",")){
            SysUserRole sysUserRole = new SysUserRole();
            sysUserRole.setRoleId(s);
            sysUserRole.setUserId(sysUser.getId());
            list.add(sysUserRole);
        }
        sysUserRoleService.insertBatch(list);
    }

    @Override
    public int updateUser(Map<String, Object> map, SysUser sysUser) {
        try {
            this.updateById(sysUser);
            updateUserRole(map,sysUser);
            return 0;
        }catch (Throwable t){
            throw new ServiceException(-1,"用户修改失败",t);
        }
    }

    @Override
    public int insertUser(Map<String, Object> map,SysUser sysUser) {
        try {
            this.insert(sysUser);
            updateUserRole(map,sysUser);
            return 0;
        }catch (Throwable t){
            throw new ServiceException(-1,"用户新增失败",t);
        }
    }

    @Override
    public int deleteUser(Map<String, Object> map,SysUser sysUser) {
        try {
            this.deleteByMap(map);
            sysUserRoleService.deleteByMap(map);
            return 0;
        }catch (Throwable t){
            throw new ServiceException(-1,"用户删除失败",t);
        }
    }
}
