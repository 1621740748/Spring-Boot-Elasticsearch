package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.alibaba.fastjson.JSON;
import com.example.demo.entity.Poem;
import com.example.demo.service.PoemServiceImpl;

/**
 * Created by linziyu on 2018/5/19.
 * 控制层
 *
 */

@Controller
public class PoemController {
	@Autowired
	private PoemServiceImpl poemService;

	@RequestMapping(value="/poem/save",method=RequestMethod.POST)
	public String savePoem(Poem poem){
        poem.setId(System.currentTimeMillis());
        System.out.println(JSON.toJSONString(poem));
        
		poemService.save(poem);
		return "/poem/ok";
	}
	@RequestMapping("/")
	public String poemPage(){
		return "poem/poem";
	}



}
