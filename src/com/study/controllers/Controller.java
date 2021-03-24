package com.study.controllers;

import java.util.Map;

import com.study.util.Criteria;

public interface Controller {
	String exec(Map<String, Object> model) throws Exception;

}
