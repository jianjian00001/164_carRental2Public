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


import com.cl.dao.ZucheDao;
import com.cl.entity.ZucheEntity;
import com.cl.service.ZucheService;
import com.cl.entity.view.ZucheView;

@Service("zucheService")
public class ZucheServiceImpl extends ServiceImpl<ZucheDao, ZucheEntity> implements ZucheService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ZucheEntity> page = this.selectPage(
                new Query<ZucheEntity>(params).getPage(),
                new EntityWrapper<ZucheEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ZucheEntity> wrapper) {
		  Page<ZucheView> page =new Query<ZucheView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<ZucheView> selectListView(Wrapper<ZucheEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ZucheView selectView(Wrapper<ZucheEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
