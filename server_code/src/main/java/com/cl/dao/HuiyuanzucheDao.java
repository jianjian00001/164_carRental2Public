package com.cl.dao;

import com.cl.entity.HuiyuanzucheEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.HuiyuanzucheView;


/**
 * 会员租车
 * 
 * @author 
 * @email 
 * @date 2024-03-17 21:59:17
 */
public interface HuiyuanzucheDao extends BaseMapper<HuiyuanzucheEntity> {
	
	List<HuiyuanzucheView> selectListView(@Param("ew") Wrapper<HuiyuanzucheEntity> wrapper);

	List<HuiyuanzucheView> selectListView(Pagination page,@Param("ew") Wrapper<HuiyuanzucheEntity> wrapper);
	
	HuiyuanzucheView selectView(@Param("ew") Wrapper<HuiyuanzucheEntity> wrapper);
	

}
