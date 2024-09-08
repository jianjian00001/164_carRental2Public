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

import com.cl.entity.HaicheEntity;
import com.cl.entity.view.HaicheView;

import com.cl.service.HaicheService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 还车
 * 后端接口
 * @author 
 * @email 
 * @date 2024-03-17 21:59:18
 */
@RestController
@RequestMapping("/haiche")
public class HaicheController {
    @Autowired
    private HaicheService haicheService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,HaicheEntity haiche,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			haiche.setZhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<HaicheEntity> ew = new EntityWrapper<HaicheEntity>();

		PageUtils page = haicheService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, haiche), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,HaicheEntity haiche, 
		HttpServletRequest request){
        EntityWrapper<HaicheEntity> ew = new EntityWrapper<HaicheEntity>();

		PageUtils page = haicheService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, haiche), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( HaicheEntity haiche){
       	EntityWrapper<HaicheEntity> ew = new EntityWrapper<HaicheEntity>();
      	ew.allEq(MPUtil.allEQMapPre( haiche, "haiche")); 
        return R.ok().put("data", haicheService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(HaicheEntity haiche){
        EntityWrapper< HaicheEntity> ew = new EntityWrapper< HaicheEntity>();
 		ew.allEq(MPUtil.allEQMapPre( haiche, "haiche")); 
		HaicheView haicheView =  haicheService.selectView(ew);
		return R.ok("查询还车成功").put("data", haicheView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        HaicheEntity haiche = haicheService.selectById(id);
		haiche = haicheService.selectView(new EntityWrapper<HaicheEntity>().eq("id", id));
        return R.ok().put("data", haiche);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        HaicheEntity haiche = haicheService.selectById(id);
		haiche = haicheService.selectView(new EntityWrapper<HaicheEntity>().eq("id", id));
        return R.ok().put("data", haiche);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody HaicheEntity haiche, HttpServletRequest request){
    	haiche.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(haiche);
        haicheService.insert(haiche);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody HaicheEntity haiche, HttpServletRequest request){
    	haiche.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(haiche);
        haicheService.insert(haiche);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody HaicheEntity haiche, HttpServletRequest request){
        //ValidatorUtils.validateEntity(haiche);
        haicheService.updateById(haiche);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        haicheService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
