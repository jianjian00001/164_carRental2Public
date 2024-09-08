package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.HuiyuanhaicheEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.HuiyuanhaicheView;


/**
 * 会员还车
 *
 * @author 
 * @email 
 * @date 2024-03-17 21:59:18
 */
public interface HuiyuanhaicheService extends IService<HuiyuanhaicheEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<HuiyuanhaicheView> selectListView(Wrapper<HuiyuanhaicheEntity> wrapper);
   	
   	HuiyuanhaicheView selectView(@Param("ew") Wrapper<HuiyuanhaicheEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<HuiyuanhaicheEntity> wrapper);
   	

}

