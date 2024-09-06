//package com.willy.filter;
//
//import java.io.IOException;
//
//import org.springframework.util.StringUtils;
//
//import com.alibaba.fastjson.JSONObject;
//import com.willy.pojo.Result;
//import com.willy.utils.JwtUtils;
//
//import jakarta.servlet.Filter;
//import jakarta.servlet.FilterChain;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.ServletRequest;
//import jakarta.servlet.ServletResponse;
//import jakarta.servlet.annotation.WebFilter;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//
//@WebFilter(urlPatterns = "/*")
//public class LoginCheckFilter implements Filter {
//    @Override
//    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
//        HttpServletRequest req = (HttpServletRequest) request;
//        HttpServletResponse resp = (HttpServletResponse) response;
//
//        // 1. 獲取請求的url
//        String url = req.getRequestURL().toString();
//        System.out.println("1" +url);
//       
//        // 2. 判斷請求url中是否包含login。如果包含，說明是登錄操作，放行。
//        if (url.contains("login")) {
//            chain.doFilter(request, response);
//            return;
//        }
//        // 3. 獲取請求頭中的令牌（token）。
//        String jwt = req.getHeader("Authorization");
//        System.out.println("2"+jwt);
//        System.out.println("2-1"+req.toString());
//
//        // 4. 判斷令牌是否存在。如果不存在，返回錯誤結果（未登錄）。
//        if (!StringUtils.hasLength(jwt)) {
//            Result error = Result.error("NOT_LOGIN");
//         // 手動轉換 對象--json ---------> 阿里巴巴fastJSON
//            String notLogin = JSONObject.toJSONString(error);
//            resp.getWriter().write(notLogin);
//            return;
//
//        }
//     // 5. 解碼 token，如果解碼失敗，返回錯誤結果（未登錄）。
//        try {
//            JwtUtils.parseToken(jwt); // jwt 解碼失敗
//        } catch (Exception e) {
//            e.printStackTrace(); // 打印堆棧跟蹤
//           
//            Result error = Result.error("NOT_LOGIN"); // 返回未登錄錯誤信息
//            // 手動轉換對象為 json ---------> 阿里巴巴 fastJSON
//            String notLogin = JSONObject.toJSONString(error);
//            resp.getWriter().write(notLogin); // 寫入響應
//            return;
//        }
//
//        // 6. 執行。
//        
//        chain.doFilter(request, response); // 繼續執行過濾器鏈
//
//    }
//}
