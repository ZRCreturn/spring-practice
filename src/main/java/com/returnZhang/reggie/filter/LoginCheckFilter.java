package com.returnZhang.reggie.filter;

import com.alibaba.fastjson.JSON;
import com.returnZhang.reggie.common.BaseContext;
import com.returnZhang.reggie.common.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.AntPathMatcher;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "LoginCheckFilter", urlPatterns = "/*")
@Slf4j
public class LoginCheckFilter implements Filter {
    //路径匹配器
    public static final AntPathMatcher PATH_MATCHER = new AntPathMatcher();
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        String requestURI = request.getRequestURI();

        log.info("拦截到请求{}", requestURI);

        String[] urls = new String[]{
                "/employee/login",
                "/employee/logout",
                "/backend/**",
                "/front/**"
        };

        boolean check = check(requestURI, urls);

        if (check){
            filterChain.doFilter(request,response);
            log.info("请求无需处理", requestURI);
            return;
        }

        if (request.getSession().getAttribute("employee") != null){
            log.info("已登录，id为{}", request.getSession().getAttribute("employee"));

            Long empID = (Long) request.getSession().getAttribute("employee");
            BaseContext.setCurrentId(empID);

            filterChain.doFilter(request,response);
            return;
        }

        log.info("用户未登录");
        response.getWriter().write(JSON.toJSONString(R.error("NOTLOGIN")));
        return;
    }


    /**
     * 路径匹配
     * @param requestURI
     * @param urls
     * @return
     */
    public boolean check (String requestURI,String[] urls){
        for (String url : urls){
            boolean match = PATH_MATCHER.match(url, requestURI);
            if(match) return true;
        }
        return false;
    }
}
