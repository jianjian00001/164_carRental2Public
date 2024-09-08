package com.cl.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.cl.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.cl.annotation.IgnoreAuth;

import com.cl.entity.HuiyuanEntity;
import com.cl.entity.view.HuiyuanView;

import com.cl.service.HuiyuanService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 会员
 * 后端接口
 * @author 
 * @email 
 * @date 2024-03-17 21:59:17
 */
@RestController
@RequestMapping("/huiyuan")
public class HuiyuanController {
    @Autowired
    private HuiyuanService huiyuanService;



    
	@Autowired
	private TokenService tokenService;
	
	/**
	 * 登录
	 */
	@IgnoreAuth
	@RequestMapping(value = "/login")
	public R login(String username, String password, String captcha, HttpServletRequest request) {
		HuiyuanEntity u = huiyuanService.selectOne(new EntityWrapper<HuiyuanEntity>().eq("huiyuanzhanghao", username));
        if(u==null || !u.getMima().equals(password)) {
            return R.error("账号或密码不正确");
        }
		String token = tokenService.generateToken(u.getId(), username,"huiyuan",  "会员" );
		return R.ok().put("token", token);
	}


	
	/**
     * 注册
     */
	@IgnoreAuth
    @RequestMapping("/register")
    public R register(@RequestBody HuiyuanEntity huiyuan){
    	//ValidatorUtils.validateEntity(huiyuan);
    	HuiyuanEntity u = huiyuanService.selectOne(new EntityWrapper<HuiyuanEntity>().eq("huiyuanzhanghao", huiyuan.getHuiyuanzhanghao()));
		if(u!=null) {
			return R.error("注册用户已存在");
		}
		Long uId = new Date().getTime();
		huiyuan.setId(uId);
        huiyuanService.insert(huiyuan);
        return R.ok();
    }

	
	/**
	 * 退出
	 */
	@RequestMapping("/logout")
	public R logout(HttpServletRequest request) {
		request.getSession().invalidate();
		return R.ok("退出成功");
	}
	
	/**
     * 获取用户的session用户信息
     */
    @RequestMapping("/session")
    public R getCurrUser(HttpServletRequest request){
    	Long id = (Long)request.getSession().getAttribute("userId");
        HuiyuanEntity u = huiyuanService.selectById(id);
        return R.ok().put("data", u);
    }
    
    /**
     * 密码重置
     */
    @IgnoreAuth
	@RequestMapping(value = "/resetPass")
    public R resetPass(String username, HttpServletRequest request){
    	HuiyuanEntity u = huiyuanService.selectOne(new EntityWrapper<HuiyuanEntity>().eq("huiyuanzhanghao", username));
    	if(u==null) {
    		return R.error("账号不存在");
    	}
        u.setMima("123456");
        huiyuanService.updateById(u);
        return R.ok("密码已重置为：123456");
    }


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,HuiyuanEntity huiyuan,
		HttpServletRequest request){
        EntityWrapper<HuiyuanEntity> ew = new EntityWrapper<HuiyuanEntity>();

		PageUtils page = huiyuanService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, huiyuan), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,HuiyuanEntity huiyuan, 
		HttpServletRequest request){
        EntityWrapper<HuiyuanEntity> ew = new EntityWrapper<HuiyuanEntity>();

		PageUtils page = huiyuanService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, huiyuan), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( HuiyuanEntity huiyuan){
       	EntityWrapper<HuiyuanEntity> ew = new EntityWrapper<HuiyuanEntity>();
      	ew.allEq(MPUtil.allEQMapPre( huiyuan, "huiyuan")); 
        return R.ok().put("data", huiyuanService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(HuiyuanEntity huiyuan){
        EntityWrapper< HuiyuanEntity> ew = new EntityWrapper< HuiyuanEntity>();
 		ew.allEq(MPUtil.allEQMapPre( huiyuan, "huiyuan")); 
		HuiyuanView huiyuanView =  huiyuanService.selectView(ew);
		return R.ok("查询会员成功").put("data", huiyuanView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        HuiyuanEntity huiyuan = huiyuanService.selectById(id);
		huiyuan = huiyuanService.selectView(new EntityWrapper<HuiyuanEntity>().eq("id", id));
        return R.ok().put("data", huiyuan);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        HuiyuanEntity huiyuan = huiyuanService.selectById(id);
		huiyuan = huiyuanService.selectView(new EntityWrapper<HuiyuanEntity>().eq("id", id));
        return R.ok().put("data", huiyuan);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody HuiyuanEntity huiyuan, HttpServletRequest request){
    	huiyuan.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(huiyuan);
    	HuiyuanEntity u = huiyuanService.selectOne(new EntityWrapper<HuiyuanEntity>().eq("huiyuanzhanghao", huiyuan.getHuiyuanzhanghao()));
		if(u!=null) {
			return R.error("用户已存在");
		}
		huiyuan.setId(new Date().getTime());
        huiyuanService.insert(huiyuan);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody HuiyuanEntity huiyuan, HttpServletRequest request){
    	huiyuan.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(huiyuan);
    	HuiyuanEntity u = huiyuanService.selectOne(new EntityWrapper<HuiyuanEntity>().eq("huiyuanzhanghao", huiyuan.getHuiyuanzhanghao()));
		if(u!=null) {
			return R.error("用户已存在");
		}
		huiyuan.setId(new Date().getTime());
        huiyuanService.insert(huiyuan);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody HuiyuanEntity huiyuan, HttpServletRequest request){
        //ValidatorUtils.validateEntity(huiyuan);
        huiyuanService.updateById(huiyuan);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        huiyuanService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
