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

import com.cl.entity.HuiyuanzucheEntity;
import com.cl.entity.view.HuiyuanzucheView;

import com.cl.service.HuiyuanzucheService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 会员租车
 * 后端接口
 * @author 
 * @email 
 * @date 2024-03-17 21:59:17
 */
@RestController
@RequestMapping("/huiyuanzuche")
public class HuiyuanzucheController {
    @Autowired
    private HuiyuanzucheService huiyuanzucheService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,HuiyuanzucheEntity huiyuanzuche,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("huiyuan")) {
			huiyuanzuche.setHuiyuanzhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<HuiyuanzucheEntity> ew = new EntityWrapper<HuiyuanzucheEntity>();

		PageUtils page = huiyuanzucheService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, huiyuanzuche), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,HuiyuanzucheEntity huiyuanzuche, 
		HttpServletRequest request){
        EntityWrapper<HuiyuanzucheEntity> ew = new EntityWrapper<HuiyuanzucheEntity>();

		PageUtils page = huiyuanzucheService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, huiyuanzuche), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( HuiyuanzucheEntity huiyuanzuche){
       	EntityWrapper<HuiyuanzucheEntity> ew = new EntityWrapper<HuiyuanzucheEntity>();
      	ew.allEq(MPUtil.allEQMapPre( huiyuanzuche, "huiyuanzuche")); 
        return R.ok().put("data", huiyuanzucheService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(HuiyuanzucheEntity huiyuanzuche){
        EntityWrapper< HuiyuanzucheEntity> ew = new EntityWrapper< HuiyuanzucheEntity>();
 		ew.allEq(MPUtil.allEQMapPre( huiyuanzuche, "huiyuanzuche")); 
		HuiyuanzucheView huiyuanzucheView =  huiyuanzucheService.selectView(ew);
		return R.ok("查询会员租车成功").put("data", huiyuanzucheView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        HuiyuanzucheEntity huiyuanzuche = huiyuanzucheService.selectById(id);
		huiyuanzuche = huiyuanzucheService.selectView(new EntityWrapper<HuiyuanzucheEntity>().eq("id", id));
        return R.ok().put("data", huiyuanzuche);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        HuiyuanzucheEntity huiyuanzuche = huiyuanzucheService.selectById(id);
		huiyuanzuche = huiyuanzucheService.selectView(new EntityWrapper<HuiyuanzucheEntity>().eq("id", id));
        return R.ok().put("data", huiyuanzuche);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody HuiyuanzucheEntity huiyuanzuche, HttpServletRequest request){
    	huiyuanzuche.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(huiyuanzuche);
        huiyuanzucheService.insert(huiyuanzuche);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody HuiyuanzucheEntity huiyuanzuche, HttpServletRequest request){
    	huiyuanzuche.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(huiyuanzuche);
        huiyuanzucheService.insert(huiyuanzuche);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody HuiyuanzucheEntity huiyuanzuche, HttpServletRequest request){
        //ValidatorUtils.validateEntity(huiyuanzuche);
        huiyuanzucheService.updateById(huiyuanzuche);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        huiyuanzucheService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
