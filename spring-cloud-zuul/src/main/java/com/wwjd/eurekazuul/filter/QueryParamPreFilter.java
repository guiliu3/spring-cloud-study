package com.wwjd.eurekazuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.springframework.stereotype.Component;

/**
 * @author liugui
 * @version V1.0
 * @Package com.wwjd.eurekazuul.filter
 * @date 2022/5/11 21:58
 * @Copyright © 上海卓繁
 */
@Component
public class QueryParamPreFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        String uri = ctx.getRequest().getRequestURI();
        System.out.println("进入QueryParamPreFilter 过滤器,请求地址：" + uri);
        return null;
    }
}
