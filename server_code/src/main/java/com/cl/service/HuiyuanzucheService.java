package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.HuiyuanzucheEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.HuiyuanzucheView;


/**
 * 会员租车
 *
 * @author 
 * @email 
 * @date 2024-03-17 21:59:17
 */
public interface HuiyuanzucheService extends IService<HuiyuanzucheEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<HuiyuanzucheView> selectListView(Wrapper<HuiyuanzucheEntity> wrapper);
   	
   	HuiyuanzucheView selectView(@Param("ew") Wrapper<HuiyuanzucheEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<HuiyuanzucheEntity> wrapper);
   	

}

