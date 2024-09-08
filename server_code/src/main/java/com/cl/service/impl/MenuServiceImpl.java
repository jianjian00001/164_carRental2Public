package com.cl.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.cl.utils.PageUtils;
import com.cl.utils.Query;


import com.cl.dao.MenuDao;
import com.cl.entity.MenuEntity;
import com.cl.service.MenuService;
import com.cl.entity.view.MenuView;

@Service("menuService")
public class MenuServiceImpl extends ServiceImpl<MenuDao, MenuEntity> implements MenuService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<MenuEntity> page = this.selectPage(
                new Query<MenuEntity>(params).getPage(),
                new EntityWrapper<MenuEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<MenuEntity> wrapper) {
		  Page<MenuView> page =new Query<MenuView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<MenuView> selectListView(Wrapper<MenuEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public MenuView selectView(Wrapper<MenuEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
