package com.yangzj.miniboot.config.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * description:
 *
 * @author yangzj
 * @date 2020/03/26
 */
@WebFilter(filterName = "MyFilter2", urlPatterns = "/config/*")
public class MyFilter2 implements Filter {

    private static final Logger logger = LoggerFactory.getLogger(MyFilter2.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        logger.info("初始化过滤器2：", filterConfig.getFilterName());
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        // 对request进行一些预处理
        servletRequest.setCharacterEncoding("UTF-8");

        logger.info("请求的host为：" + servletRequest.getRemoteHost());

        // 放行，继续执行后续的过滤器链，过滤器基于servlet，优先基于框架的interceptor
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
        logger.info("销毁过滤器2");
    }
}
