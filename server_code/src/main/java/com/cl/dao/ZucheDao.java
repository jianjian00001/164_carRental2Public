package com.cl.dao;

import com.cl.entity.ZucheEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.ZucheView;


/**
 * 租车
 * 
 * @author 
 * @email 
 * @date 2024-03-17 21:59:17
 */
public interface ZucheDao extends BaseMapper<ZucheEntity> {
	
	List<ZucheView> selectListView(@Param("ew") Wrapper<ZucheEntity> wrapper);

	List<ZucheView> selectListView(Pagination page,@Param("ew") Wrapper<ZucheEntity> wrapper);
	
	ZucheView selectView(@Param("ew") Wrapper<ZucheEntity> wrapper);
	

}
