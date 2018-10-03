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
public class SearchController {
	@Autowired
	private PoemServiceImpl poemService;

	@RequestMapping("/searchWord")
	public String searchWord(String content, @RequestParam(value="pageIndex",required=false,defaultValue="0") int pageIndex,
			@RequestParam(value="pageSize",required=false,defaultValue="10") int pageSize,Model model) {
		Pageable pageable = new PageRequest(pageIndex,pageSize);
		Page<Poem> poems = poemService.searchWord(content,pageable);
		List<Poem> list = poems.getContent();
		model.addAttribute("poems",list);
		return "/list";

	}
	@RequestMapping("/s1")
	public String s1(
			@RequestParam(value="pageIndex",required=false,defaultValue="0") int pageIndex,
			@RequestParam(value="pageSize",required=false,defaultValue="10") int pageSize,
			Model model) {
		Pageable pageable = new PageRequest(pageIndex,pageSize);
		Page<Poem> poems = poemService.findAll(pageable);
		model.addAttribute("poems",poems);
		return "/search/s1";
	}



}
