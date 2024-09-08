package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.ZucheEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.ZucheView;


/**
 * 租车
 *
 * @author 
 * @email 
 * @date 2024-03-17 21:59:17
 */
public interface ZucheService extends IService<ZucheEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ZucheView> selectListView(Wrapper<ZucheEntity> wrapper);
   	
   	ZucheView selectView(@Param("ew") Wrapper<ZucheEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ZucheEntity> wrapper);
   	

}

