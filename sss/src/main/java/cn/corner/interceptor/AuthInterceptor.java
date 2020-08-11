package cn.corner.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @company: yzw
 * @author: connor.h.liu
 * @version: V1.0
 * date: 2020-08-11 10:15
 */
public class AuthInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        if (session == null) {
            response.sendRedirect("/login/page");
            return false;
        }
        Object user = session.getAttribute("user");
        if (user == null) {
            response.sendRedirect("/login/page");
            return false;
        }
        return true;
    }
}
