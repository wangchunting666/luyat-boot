package com.ly.ams.web;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.ly.ams.service.ISysUserService;
import com.ly.ams.util.controller.SuperController;
import com.ly.ams.vo.SysUser;
import com.ly.tls.baseclass.OToInt;
import com.ly.tls.baseclass.OToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 */
@RestController
@RequestMapping("/system/user")
public class SysUserController extends SuperController{

    @Autowired private ISysUserService sysUserService;

    /**
     * 分页查询用户
     */
    @RequestMapping("/list")
    public Object list(@RequestBody Map<String,Object> map){
        logger.debug(map);
        String search = OToString.toBlank(map.get("search"));
        Page<SysUser> page = new Page<>(OToInt.toInt(map.get("page")),OToInt.toInt(map.get("limit")));
        page.setOrderByField(StrUtil.isBlankIfStr(map.get("sidx"))?defaultSidx:StrUtil.utf8Str(map.get("sidx")));
        page.setAsc("asc".equalsIgnoreCase(StrUtil.utf8Str(map.get("sord")))?true:false);
        EntityWrapper<SysUser> ew = new EntityWrapper<SysUser>();
        setSearch(ew.where("1=1"),search);
        Page<Map<String,Object>> pageData = sysUserService.selectMapsPage(page,ew);
        return pageData;
    }

    @RequestMapping("/edit")
    public Object edit(@RequestBody Map<String,Object> map){
        sysUserService.updateUser(map,new SysUser());
        return null;
    }
}

