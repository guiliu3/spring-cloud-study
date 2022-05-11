package com.wwjd.eurekazuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.springframework.stereotype.Component;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author liugui
 * @version V1.0
 * @Package com.wwjd.eurekazuul.filter
 * @date 2022/5/11 22:02
 * @Copyright © 上海卓繁
 */
@Component
public class QueryParamRoutingFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return "route";
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
        System.out.println("进入到QueryParamRoutingFilter过滤器");
        //根据请求参数设置不通的值
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletResponse response = ctx.getResponse();
        try {
            HttpServletRequest request = ctx.getRequest();
            String flag = request.getParameter("flag");
            if ("1".equals(flag)) {
                ctx.setResponseStatusCode(401);
                // 不进行路由
                ctx.setSendZuulResponse(false);
                //返回错误消息
                ServletOutputStream outputStream = response.getOutputStream();
                outputStream.print("flag=1 return error!");
                outputStream.flush();
                outputStream.close();
            } else if ("2".equals(flag)) {
                //不进行路由
                ctx.setSendZuulResponse(false);
                ctx.setResponseStatusCode(402);
                ctx.set("name", "test");
                //返回错误消息
                ctx.setResponseBody("flag=2 return error!");

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        ctx.setResponse(response);
        return null;
    }
}
