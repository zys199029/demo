package com.cogitationsoft.findit.controller;

import com.cogitationsoft.findit.service.impl.DemoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: Andy
 * @date: 5/3/2018 3:55 PM
 * @description: 主控制器
 * @version: 1.0
 */
@Controller
public class IndexController {

	@Autowired
	private DemoServiceImpl service;
	/**
	 * Method Description:
	 * 〈负责跳转到首页〉
	 *
	 * @param:      null
	 * @return:     String： index explain: view name
	 * @author:     Andy
	 * @date:       5/3/2018 3:57 PM
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(){
		service.insert();
		return "index";
	}
}
