package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.HaicheEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.HaicheView;


/**
 * 还车
 *
 * @author 
 * @email 
 * @date 2024-03-17 21:59:18
 */
public interface HaicheService extends IService<HaicheEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<HaicheView> selectListView(Wrapper<HaicheEntity> wrapper);
   	
   	HaicheView selectView(@Param("ew") Wrapper<HaicheEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<HaicheEntity> wrapper);
   	

}

