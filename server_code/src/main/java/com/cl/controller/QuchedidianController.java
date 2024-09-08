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

import com.cl.entity.QuchedidianEntity;
import com.cl.entity.view.QuchedidianView;

import com.cl.service.QuchedidianService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 取车地点
 * 后端接口
 * @author 
 * @email 
 * @date 2024-03-17 21:59:17
 */
@RestController
@RequestMapping("/quchedidian")
public class QuchedidianController {
    @Autowired
    private QuchedidianService quchedidianService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,QuchedidianEntity quchedidian,
		HttpServletRequest request){
        EntityWrapper<QuchedidianEntity> ew = new EntityWrapper<QuchedidianEntity>();

		PageUtils page = quchedidianService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, quchedidian), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,QuchedidianEntity quchedidian, 
		HttpServletRequest request){
        EntityWrapper<QuchedidianEntity> ew = new EntityWrapper<QuchedidianEntity>();

		PageUtils page = quchedidianService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, quchedidian), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( QuchedidianEntity quchedidian){
       	EntityWrapper<QuchedidianEntity> ew = new EntityWrapper<QuchedidianEntity>();
      	ew.allEq(MPUtil.allEQMapPre( quchedidian, "quchedidian")); 
        return R.ok().put("data", quchedidianService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(QuchedidianEntity quchedidian){
        EntityWrapper< QuchedidianEntity> ew = new EntityWrapper< QuchedidianEntity>();
 		ew.allEq(MPUtil.allEQMapPre( quchedidian, "quchedidian")); 
		QuchedidianView quchedidianView =  quchedidianService.selectView(ew);
		return R.ok("查询取车地点成功").put("data", quchedidianView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        QuchedidianEntity quchedidian = quchedidianService.selectById(id);
		quchedidian = quchedidianService.selectView(new EntityWrapper<QuchedidianEntity>().eq("id", id));
        return R.ok().put("data", quchedidian);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        QuchedidianEntity quchedidian = quchedidianService.selectById(id);
		quchedidian = quchedidianService.selectView(new EntityWrapper<QuchedidianEntity>().eq("id", id));
        return R.ok().put("data", quchedidian);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody QuchedidianEntity quchedidian, HttpServletRequest request){
    	quchedidian.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(quchedidian);
        quchedidianService.insert(quchedidian);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody QuchedidianEntity quchedidian, HttpServletRequest request){
    	quchedidian.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(quchedidian);
        quchedidianService.insert(quchedidian);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody QuchedidianEntity quchedidian, HttpServletRequest request){
        //ValidatorUtils.validateEntity(quchedidian);
        quchedidianService.updateById(quchedidian);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        quchedidianService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
