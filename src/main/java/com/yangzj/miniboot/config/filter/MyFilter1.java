package com.yangzj.miniboot.config.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * description: 过滤器侧重于像漏斗一样过滤
 * 拦截器侧重于切面增强，其实两者都蕴含了AOP的设计思想，但侧重点不同
 *
 * @author yangzj
 * @date 2020/03/26
 */
@WebFilter(filterName = "MyFilter1", urlPatterns = "/*")
public class MyFilter1 implements Filter {

    private static final Logger logger = LoggerFactory.getLogger(MyFilter1.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        logger.info("初始化过滤器1：", filterConfig.getFilterName());
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        // 对request和response进行一些预处理
        servletRequest.setCharacterEncoding("UTF-8");
        servletResponse.setCharacterEncoding("UTF-8");
        servletResponse.setContentType("text/html;charset=UTF-8");

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        String requestUri = request.getRequestURI();
        logger.info("请求的接口为：" + requestUri);

        // 放行，继续执行后续的过滤器链，过滤器基于servlet，优先基于框架的interceptor
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
        logger.info("销毁过滤器1");
    }
}
