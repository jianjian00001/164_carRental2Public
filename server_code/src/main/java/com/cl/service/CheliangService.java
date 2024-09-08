package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.CheliangEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.CheliangView;


/**
 * 车辆
 *
 * @author 
 * @email 
 * @date 2024-03-17 21:59:17
 */
public interface CheliangService extends IService<CheliangEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<CheliangView> selectListView(Wrapper<CheliangEntity> wrapper);
   	
   	CheliangView selectView(@Param("ew") Wrapper<CheliangEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<CheliangEntity> wrapper);
   	

}

