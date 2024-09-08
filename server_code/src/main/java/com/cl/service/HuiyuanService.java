package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.HuiyuanEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.HuiyuanView;


/**
 * 会员
 *
 * @author 
 * @email 
 * @date 2024-03-17 21:59:17
 */
public interface HuiyuanService extends IService<HuiyuanEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<HuiyuanView> selectListView(Wrapper<HuiyuanEntity> wrapper);
   	
   	HuiyuanView selectView(@Param("ew") Wrapper<HuiyuanEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<HuiyuanEntity> wrapper);
   	

}

