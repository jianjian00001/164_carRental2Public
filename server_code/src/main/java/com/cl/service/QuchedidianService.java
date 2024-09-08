package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.QuchedidianEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.QuchedidianView;


/**
 * 取车地点
 *
 * @author 
 * @email 
 * @date 2024-03-17 21:59:17
 */
public interface QuchedidianService extends IService<QuchedidianEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<QuchedidianView> selectListView(Wrapper<QuchedidianEntity> wrapper);
   	
   	QuchedidianView selectView(@Param("ew") Wrapper<QuchedidianEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<QuchedidianEntity> wrapper);
   	

}

