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

import com.cl.entity.ZucheEntity;
import com.cl.entity.view.ZucheView;

import com.cl.service.ZucheService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 租车
 * 后端接口
 * @author 
 * @email 
 * @date 2024-03-17 21:59:17
 */
@RestController
@RequestMapping("/zuche")
public class ZucheController {
    @Autowired
    private ZucheService zucheService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ZucheEntity zuche,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			zuche.setZhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<ZucheEntity> ew = new EntityWrapper<ZucheEntity>();

		PageUtils page = zucheService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, zuche), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,ZucheEntity zuche, 
		HttpServletRequest request){
        EntityWrapper<ZucheEntity> ew = new EntityWrapper<ZucheEntity>();

		PageUtils page = zucheService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, zuche), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ZucheEntity zuche){
       	EntityWrapper<ZucheEntity> ew = new EntityWrapper<ZucheEntity>();
      	ew.allEq(MPUtil.allEQMapPre( zuche, "zuche")); 
        return R.ok().put("data", zucheService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ZucheEntity zuche){
        EntityWrapper< ZucheEntity> ew = new EntityWrapper< ZucheEntity>();
 		ew.allEq(MPUtil.allEQMapPre( zuche, "zuche")); 
		ZucheView zucheView =  zucheService.selectView(ew);
		return R.ok("查询租车成功").put("data", zucheView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ZucheEntity zuche = zucheService.selectById(id);
		zuche = zucheService.selectView(new EntityWrapper<ZucheEntity>().eq("id", id));
        return R.ok().put("data", zuche);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ZucheEntity zuche = zucheService.selectById(id);
		zuche = zucheService.selectView(new EntityWrapper<ZucheEntity>().eq("id", id));
        return R.ok().put("data", zuche);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ZucheEntity zuche, HttpServletRequest request){
    	zuche.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(zuche);
        zucheService.insert(zuche);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ZucheEntity zuche, HttpServletRequest request){
    	zuche.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(zuche);
        zucheService.insert(zuche);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody ZucheEntity zuche, HttpServletRequest request){
        //ValidatorUtils.validateEntity(zuche);
        zucheService.updateById(zuche);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        zucheService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
