package com.cl.dao;

import com.cl.entity.HuiyuanhaicheEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.HuiyuanhaicheView;


/**
 * 会员还车
 * 
 * @author 
 * @email 
 * @date 2024-03-17 21:59:18
 */
public interface HuiyuanhaicheDao extends BaseMapper<HuiyuanhaicheEntity> {
	
	List<HuiyuanhaicheView> selectListView(@Param("ew") Wrapper<HuiyuanhaicheEntity> wrapper);

	List<HuiyuanhaicheView> selectListView(Pagination page,@Param("ew") Wrapper<HuiyuanhaicheEntity> wrapper);
	
	HuiyuanhaicheView selectView(@Param("ew") Wrapper<HuiyuanhaicheEntity> wrapper);
	

}
