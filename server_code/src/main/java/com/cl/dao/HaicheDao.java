package com.cl.dao;

import com.cl.entity.HaicheEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.HaicheView;


/**
 * 还车
 * 
 * @author 
 * @email 
 * @date 2024-03-17 21:59:18
 */
public interface HaicheDao extends BaseMapper<HaicheEntity> {
	
	List<HaicheView> selectListView(@Param("ew") Wrapper<HaicheEntity> wrapper);

	List<HaicheView> selectListView(Pagination page,@Param("ew") Wrapper<HaicheEntity> wrapper);
	
	HaicheView selectView(@Param("ew") Wrapper<HaicheEntity> wrapper);
	

}
