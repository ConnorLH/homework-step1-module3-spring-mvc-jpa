package com.lagou.edu.mvcframework.pojo;

import com.lagou.edu.mvcframework.interceptor.HandlerInterceptor;
import com.lagou.utils.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * handler链
 * @company: yzw
 * @author: connor.h.liu
 * @version: V1.0
 * date: 2020-08-10 17:42
 */
public class HandlerExecutionChain {

    private final Object handler;

    private List<HandlerInterceptor> interceptorList;

    public HandlerExecutionChain(Object handler,HandlerInterceptor... interceptors) {
        this.handler = handler;
        this.interceptorList = new ArrayList<>();
        CollectionUtils.mergeArrayIntoCollection(interceptors, this.interceptorList);
    }

    public void addInterceptor(HandlerInterceptor interceptor) {
        this.interceptorList.add(interceptor);
    }

    public Object getHandler() {
        return handler;
    }

    public List<HandlerInterceptor> getInterceptorList() {
        return interceptorList;
    }
}
