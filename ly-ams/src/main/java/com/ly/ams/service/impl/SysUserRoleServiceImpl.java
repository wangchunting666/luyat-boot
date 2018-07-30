package com.ly.ams.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.ly.ams.dao.SysUserRoleMapper;
import com.ly.ams.service.ISysUserRoleService;
import com.ly.ams.vo.SysUserRole;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * <p>
 * 用户角色关联表 服务实现类
 * </p>
 */
@Service
@Transactional
public class SysUserRoleServiceImpl extends ServiceImpl<SysUserRoleMapper, SysUserRole> implements ISysUserRoleService {
    @Override
    public Set<String> findRolesByUid(String uid) {
        List<SysUserRole> list = this.selectList(new EntityWrapper<SysUserRole>().eq("userId", uid));
        Set<String> set = new HashSet<String>();
        for (SysUserRole ur : list) {
            set.add(ur.getRoleId());
        }
        return set;
    }
}
