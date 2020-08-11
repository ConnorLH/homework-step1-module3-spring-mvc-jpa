package com.lagou.edu.mvcframework.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 拦截器接口
 * @company: yzw
 * @author: connor.h.liu
 * @version: V1.0
 * date: 2020-08-10 17:43
 */
public interface HandlerInterceptor {

    default boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {
        return true;
    }
}
