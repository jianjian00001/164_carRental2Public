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

import com.cl.entity.CheliangEntity;
import com.cl.entity.view.CheliangView;

import com.cl.service.CheliangService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 车辆
 * 后端接口
 * @author 
 * @email 
 * @date 2024-03-17 21:59:17
 */
@RestController
@RequestMapping("/cheliang")
public class CheliangController {
    @Autowired
    private CheliangService cheliangService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,CheliangEntity cheliang,
		HttpServletRequest request){
        EntityWrapper<CheliangEntity> ew = new EntityWrapper<CheliangEntity>();

		PageUtils page = cheliangService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, cheliang), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,CheliangEntity cheliang, 
		HttpServletRequest request){
        EntityWrapper<CheliangEntity> ew = new EntityWrapper<CheliangEntity>();

		PageUtils page = cheliangService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, cheliang), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( CheliangEntity cheliang){
       	EntityWrapper<CheliangEntity> ew = new EntityWrapper<CheliangEntity>();
      	ew.allEq(MPUtil.allEQMapPre( cheliang, "cheliang")); 
        return R.ok().put("data", cheliangService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(CheliangEntity cheliang){
        EntityWrapper< CheliangEntity> ew = new EntityWrapper< CheliangEntity>();
 		ew.allEq(MPUtil.allEQMapPre( cheliang, "cheliang")); 
		CheliangView cheliangView =  cheliangService.selectView(ew);
		return R.ok("查询车辆成功").put("data", cheliangView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        CheliangEntity cheliang = cheliangService.selectById(id);
		cheliang = cheliangService.selectView(new EntityWrapper<CheliangEntity>().eq("id", id));
        return R.ok().put("data", cheliang);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        CheliangEntity cheliang = cheliangService.selectById(id);
		cheliang = cheliangService.selectView(new EntityWrapper<CheliangEntity>().eq("id", id));
        return R.ok().put("data", cheliang);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody CheliangEntity cheliang, HttpServletRequest request){
    	cheliang.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(cheliang);
        cheliangService.insert(cheliang);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody CheliangEntity cheliang, HttpServletRequest request){
    	cheliang.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(cheliang);
        cheliangService.insert(cheliang);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody CheliangEntity cheliang, HttpServletRequest request){
        //ValidatorUtils.validateEntity(cheliang);
        cheliangService.updateById(cheliang);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        cheliangService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
