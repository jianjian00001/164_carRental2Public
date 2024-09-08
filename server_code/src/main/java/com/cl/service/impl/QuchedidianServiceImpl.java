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


import com.cl.dao.QuchedidianDao;
import com.cl.entity.QuchedidianEntity;
import com.cl.service.QuchedidianService;
import com.cl.entity.view.QuchedidianView;

@Service("quchedidianService")
public class QuchedidianServiceImpl extends ServiceImpl<QuchedidianDao, QuchedidianEntity> implements QuchedidianService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<QuchedidianEntity> page = this.selectPage(
                new Query<QuchedidianEntity>(params).getPage(),
                new EntityWrapper<QuchedidianEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<QuchedidianEntity> wrapper) {
		  Page<QuchedidianView> page =new Query<QuchedidianView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<QuchedidianView> selectListView(Wrapper<QuchedidianEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public QuchedidianView selectView(Wrapper<QuchedidianEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
