package com.cl.dao;

import com.cl.entity.CheliangEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.CheliangView;


/**
 * 车辆
 * 
 * @author 
 * @email 
 * @date 2024-03-17 21:59:17
 */
public interface CheliangDao extends BaseMapper<CheliangEntity> {
	
	List<CheliangView> selectListView(@Param("ew") Wrapper<CheliangEntity> wrapper);

	List<CheliangView> selectListView(Pagination page,@Param("ew") Wrapper<CheliangEntity> wrapper);
	
	CheliangView selectView(@Param("ew") Wrapper<CheliangEntity> wrapper);
	

}
