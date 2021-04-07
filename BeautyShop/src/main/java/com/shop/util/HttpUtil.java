package com.shop.util;

import com.shop.service.ProductService;
import com.shop.service.impl.ProductServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;

public class HttpUtil {
	
	private String value;
	
	public HttpUtil(String value) {
		this.value = value;
	}
	
	public <T> T toModel(Class<T> tClass) {
		try {
			return new ObjectMapper().readValue(value, tClass);
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		return null;
	}
	
	public static HttpUtil 	of (BufferedReader reader) {
		StringBuilder sb = new StringBuilder();
		try {
			String line;
		    while ((line = reader.readLine()) != null) {
		        sb.append(line);
		    }
		} catch (IOException e) {
			System.out.print(e.getMessage());
		}
		return new HttpUtil(sb.toString());
	}
	public static void setCategory(HttpServletRequest request, ProductService productService){
		request.setAttribute("lips", productService.findAllById("idMenuCon","1","null","null"));
		request.setAttribute("skincare", productService.findAllById("idMenuCon","2","null","null"));
		request.setAttribute("makeup", productService.findAllById("idMenuCon","3","null","null"));
		request.setAttribute("perfume", productService.findAllById("idMenuCon","4","null","null"));

	}


}
