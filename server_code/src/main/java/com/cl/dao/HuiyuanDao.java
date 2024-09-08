package com.cl.dao;

import com.cl.entity.HuiyuanEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.HuiyuanView;


/**
 * 会员
 * 
 * @author 
 * @email 
 * @date 2024-03-17 21:59:17
 */
public interface HuiyuanDao extends BaseMapper<HuiyuanEntity> {
	
	List<HuiyuanView> selectListView(@Param("ew") Wrapper<HuiyuanEntity> wrapper);

	List<HuiyuanView> selectListView(Pagination page,@Param("ew") Wrapper<HuiyuanEntity> wrapper);
	
	HuiyuanView selectView(@Param("ew") Wrapper<HuiyuanEntity> wrapper);
	

}
