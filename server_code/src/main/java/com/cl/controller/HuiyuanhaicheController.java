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

import com.cl.entity.HuiyuanhaicheEntity;
import com.cl.entity.view.HuiyuanhaicheView;

import com.cl.service.HuiyuanhaicheService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 会员还车
 * 后端接口
 * @author 
 * @email 
 * @date 2024-03-17 21:59:18
 */
@RestController
@RequestMapping("/huiyuanhaiche")
public class HuiyuanhaicheController {
    @Autowired
    private HuiyuanhaicheService huiyuanhaicheService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,HuiyuanhaicheEntity huiyuanhaiche,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("huiyuan")) {
			huiyuanhaiche.setHuiyuanzhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<HuiyuanhaicheEntity> ew = new EntityWrapper<HuiyuanhaicheEntity>();

		PageUtils page = huiyuanhaicheService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, huiyuanhaiche), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,HuiyuanhaicheEntity huiyuanhaiche, 
		HttpServletRequest request){
        EntityWrapper<HuiyuanhaicheEntity> ew = new EntityWrapper<HuiyuanhaicheEntity>();

		PageUtils page = huiyuanhaicheService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, huiyuanhaiche), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( HuiyuanhaicheEntity huiyuanhaiche){
       	EntityWrapper<HuiyuanhaicheEntity> ew = new EntityWrapper<HuiyuanhaicheEntity>();
      	ew.allEq(MPUtil.allEQMapPre( huiyuanhaiche, "huiyuanhaiche")); 
        return R.ok().put("data", huiyuanhaicheService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(HuiyuanhaicheEntity huiyuanhaiche){
        EntityWrapper< HuiyuanhaicheEntity> ew = new EntityWrapper< HuiyuanhaicheEntity>();
 		ew.allEq(MPUtil.allEQMapPre( huiyuanhaiche, "huiyuanhaiche")); 
		HuiyuanhaicheView huiyuanhaicheView =  huiyuanhaicheService.selectView(ew);
		return R.ok("查询会员还车成功").put("data", huiyuanhaicheView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        HuiyuanhaicheEntity huiyuanhaiche = huiyuanhaicheService.selectById(id);
		huiyuanhaiche = huiyuanhaicheService.selectView(new EntityWrapper<HuiyuanhaicheEntity>().eq("id", id));
        return R.ok().put("data", huiyuanhaiche);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        HuiyuanhaicheEntity huiyuanhaiche = huiyuanhaicheService.selectById(id);
		huiyuanhaiche = huiyuanhaicheService.selectView(new EntityWrapper<HuiyuanhaicheEntity>().eq("id", id));
        return R.ok().put("data", huiyuanhaiche);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody HuiyuanhaicheEntity huiyuanhaiche, HttpServletRequest request){
    	huiyuanhaiche.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(huiyuanhaiche);
        huiyuanhaicheService.insert(huiyuanhaiche);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody HuiyuanhaicheEntity huiyuanhaiche, HttpServletRequest request){
    	huiyuanhaiche.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(huiyuanhaiche);
        huiyuanhaicheService.insert(huiyuanhaiche);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody HuiyuanhaicheEntity huiyuanhaiche, HttpServletRequest request){
        //ValidatorUtils.validateEntity(huiyuanhaiche);
        huiyuanhaicheService.updateById(huiyuanhaiche);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        huiyuanhaicheService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
