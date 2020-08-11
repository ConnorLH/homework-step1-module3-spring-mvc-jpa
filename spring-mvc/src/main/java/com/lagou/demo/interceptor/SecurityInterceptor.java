package com.lagou.demo.interceptor;

import com.lagou.edu.mvcframework.annotations.LagouService;
import com.lagou.edu.mvcframework.annotations.Security;
import com.lagou.edu.mvcframework.interceptor.HandlerInterceptor;
import com.lagou.edu.mvcframework.pojo.Handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

/**
 * 权限拦截器
 * @company: yzw
 * @author: connor.h.liu
 * @version: V1.0
 * date: 2020-08-10 21:21
 */
@LagouService
public class SecurityInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {
        Method method = ((Handler) handler).getMethod();
        Security security = method.getAnnotation(Security.class);
        if (security != null) {
            String username = request.getParameter("username");
            String[] users = security.value();
            for (String user : users) {
                if (user.equals(username)) {
                    return true;
                }
            }
        } else {
            return true;
        }
        response.setStatus(401);
        response.getWriter().write("401 no authority");
        return false;
    }
}
