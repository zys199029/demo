package com.cogitationsoft.findit.mapper;

import com.cogitationsoft.findit.pojo.DemoDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author: Andy
 * @date : 5/4/2018 9:19 AM
 * @description: DemoMapper
 * @version: 1.0
 */
@Mapper
public interface DemoMapper {

	/** @description： 插入样例  */
	public void insert (DemoDO demo);

}
