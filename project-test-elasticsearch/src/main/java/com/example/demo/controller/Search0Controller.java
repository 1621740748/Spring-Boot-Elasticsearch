package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Poem;
import com.example.demo.service.PoemServiceImpl;

/**
 * Created by linziyu on 2018/5/19.
 * 控制层
 *
 */

@Controller
public class Search0Controller {
	@Autowired
	private PoemServiceImpl poemService;

	@RequestMapping("/s0")
	public String index1(
			@RequestParam(value="pageIndex",required=false,defaultValue="0") int pageIndex,
			@RequestParam(value="pageSize",required=false,defaultValue="10") int pageSize,
			Model model) {
		Pageable pageable = new PageRequest(pageIndex,pageSize);
		Page<Poem> poems = poemService.findAll(pageable);
		List<Poem> poems1 = poems.getContent();
		model.addAttribute("poems",poems);
		return "/search0/index";
	}

	@RequestMapping("/search")
	public String search(String content, @RequestParam(value="pageIndex",required=false,defaultValue="0") int pageIndex,
			@RequestParam(value="pageSize",required=false,defaultValue="10") int pageSize,Model model) {
		Pageable pageable = new PageRequest(pageIndex,pageSize);
		Page<Poem> poems = poemService.search(content,pageable);
		List<Poem> list = poems.getContent();
		model.addAttribute("poems",list);
		return "/search0/list";

	}




}
