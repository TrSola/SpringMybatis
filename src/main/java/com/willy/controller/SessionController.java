package com.willy.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.willy.pojo.Result;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@RestController
public class SessionController {

	@GetMapping("/c1")
    public Result cookie1(HttpServletResponse response) {
        response.addCookie(new Cookie("login_username", "itheima")); // 設置 Cookie
        return Result.success();
    }

    // 獲取 Cookie
    @GetMapping("/c2")
    public Result cookie2(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies(); // 獲取所有的 Cookie
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("login_username")) { // 輸出 name 為 login_username 的 cookie
                System.out.println("login_username: " + cookie.getValue());
            }
        }
        return Result.success();
    }
	
    @GetMapping("/s1")
    public Result session1(HttpSession session) {
        System.out.println("session s1:" + session.hashCode());
        session.setAttribute("loginUser", "tom"); // 在 session 中存儲數據
        return Result.success();
    }

    @GetMapping("/s2")
    public Result session2(HttpServletRequest request) {
        HttpSession session = request.getSession();
        System.out.println("session s2:" + session.hashCode());
        Object loginUser = session.getAttribute("loginUser"); // 從 session 中獲取數據
        return Result.success(loginUser);
    }
}
