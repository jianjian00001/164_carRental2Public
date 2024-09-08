package com.cl.dao;

import com.cl.entity.QuchedidianEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.QuchedidianView;


/**
 * 取车地点
 * 
 * @author 
 * @email 
 * @date 2024-03-17 21:59:17
 */
public interface QuchedidianDao extends BaseMapper<QuchedidianEntity> {
	
	List<QuchedidianView> selectListView(@Param("ew") Wrapper<QuchedidianEntity> wrapper);

	List<QuchedidianView> selectListView(Pagination page,@Param("ew") Wrapper<QuchedidianEntity> wrapper);
	
	QuchedidianView selectView(@Param("ew") Wrapper<QuchedidianEntity> wrapper);
	

}
