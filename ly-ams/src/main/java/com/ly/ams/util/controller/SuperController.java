package com.ly.ams.util.controller;

import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.ly.tls.baseclass.OToString;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * 基础控制器
 * @author Gaojun.Zhou
 * @date 2016年12月27日 上午11:50:57
 */
public class SuperController {
	protected Logger logger = LogManager.getLogger(this.getClass());
	protected final String defaultSort = "asc";
	protected final String defaultSidx = "createtime";

	protected <T> void setSearch(Wrapper<T> ew, String search){
		if(!StrUtil.isNotEmpty(search)){return;}
		JSONObject json = JSONUtil.parseObj(search);
		Object groupOp = json.get("groupOp");
		if(groupOp ==null || !StrUtil.isNotEmpty(OToString.toBlank(groupOp))){return;}

		Object rules = json.get("rules");
		if(rules != null && StrUtil.isNotBlank(OToString.toBlank(rules))){
			JSONArray jsonArray = JSONUtil.parseArray(rules.toString());
			for(Object obj:jsonArray){
				JSONObject jsonObject = JSONUtil.parseObj(obj);
				if("AND".equals(groupOp)){
					ew.and("("+getSqlOp(jsonObject.get("op").toString(),jsonObject.get("field").toString(),jsonObject.get("data").toString())+")");
				}else if("OR".equals(groupOp)){
					ew.or("("+getSqlOp(jsonObject.get("op").toString(),jsonObject.get("field").toString(),jsonObject.get("data").toString())+")");
				}
			}
		}
	}

	private String getSqlOp(String op,String name,String data){
		if("eq".equals(op) && data != null && !"".equals(data)) return name + " = " + "'"+data+"'";
		if("ne".equals(op) && data != null && !"".equals(data)) return name + " <> " + "'"+data+"'";
		if("lt".equals(op) && data != null && !"".equals(data)) return name + " < " + "'"+data+"'";
		if("le".equals(op) && data != null && !"".equals(data)) return name + " <= " + "'"+data+"'";
		if("gt".equals(op) && data != null && !"".equals(data)) return name + " > " + "'"+data+"'";
		if("ge".equals(op) && data != null && !"".equals(data)) return name + " >= " + "'"+data+"'";
		if("in".equals(op) && data != null && !"".equals(data)) return name + " in " + "'"+data+"'";
		if("ni".equals(op) && data != null && !"".equals(data)) return name + " not in " + "'"+data+"'";
		if("cn".equals(op) && data != null && !"".equals(data)) return name + " like " + "'%"+data+"%'";
		if("nc".equals(op) && data != null && !"".equals(data)) return name + " not like " + "'%"+data+"%'";
		return "";
	}

}
