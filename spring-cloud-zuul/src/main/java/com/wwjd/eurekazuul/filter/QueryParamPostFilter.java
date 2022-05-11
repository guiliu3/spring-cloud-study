package com.wwjd.eurekazuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.springframework.stereotype.Component;

/**
 * @author liugui
 * @version V1.0
 * @Package com.wwjd.eurekazuul.filter
 * @date 2022/5/11 22:02
 * @Copyright © 上海卓繁
 */
@Component
public class QueryParamPostFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return "post";
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
        System.out.println("进入到QueryParamPostFilter过滤器");
        RequestContext ctx = RequestContext.getCurrentContext();
        System.out.println("responseStatusCode:" + ctx.getResponseStatusCode());
        System.out.println("responseBody:" + ctx.getResponseBody());
        Object object = ctx.get("name");
        System.out.println("name:" + object);
        return null;
    }
}
