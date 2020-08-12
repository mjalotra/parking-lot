package com.parkinglot.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/hacker-news")
public class HackerNewsController {
	
	
	@Autowired 
	private RestTemplate restTemplate;
	
//	@Autowired
	private HackerNewsConfig hackerNewsConfig;
	
	@GetMapping("/call")
	@ApiOperation(value = "print report of collections", produces = "application/json")
	public String getNews() throws URISyntaxException{
		URI uri = new URI("https://hacker-news.firebaseio.com/v0/topstories.json");
		String s= restTemplate.getForObject(uri, String.class);
		Executor executor = Executors.newFixedThreadPool(5);
//		executor.execute(hackerNewsConfig.get);
		System.out.println(s);
		return s;
	}
}
