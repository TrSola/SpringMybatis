package com.willy.filter;

import io.jsonwebtoken.io.IOException;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;

//@WebFilter(urlPatterns = "/*") // 設定過濾器的 URL 模式
public class DemoFilter implements Filter {
    
    public void init(FilterConfig filterConfig) throws ServletException { // 初始化方法，Web 伺服器啟動時，建立 Filter 時調用，只調用一次
        Filter.super.init(filterConfig);
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException { // 當請求到達時，調用該方法，可調用多次
        System.out.println("過濾方法執行，獲取到請求 ...");
        try {
			chain.doFilter(request, response);
		} catch (java.io.IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // 繼續執行後續過濾器或目標資源
    }

    public void destroy() { // 銷毀方法，伺服器關閉時調用，只調用一次
        Filter.super.destroy();
    }
}

