package org.example.qff.interceptors;

import org.example.qff.common.util.JwtUtil;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

import static org.example.qff.common.result.ErrorCode.NO_AUTH;

/**
 * @author liufan
 * @version 1.0
 * @date 2024/12/7 15:19
 * 令牌拦截器
 **/
@Component
public class LoginInterceptors implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //获取令牌
        String token = request.getHeader("Authorization");
        //验证token
        try {
            Map<String, Object> creatJwt = JwtUtil.parseJwt(token);
            return true;
        } catch (Exception e) {
            response.setStatus(NO_AUTH.getCode());
            return false;
        }
    }
}
