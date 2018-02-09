package com.wwjd.eurekaribbon.util;

import org.apache.commons.lang.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.Map;

/**
 * @author 董朱旭
 * @version BUILD1001
 * @fileName com.wwjd.eurekaribbon.util.RequstUtil.java
 * @CopyRright (c) 2017-bxm：杭州微财科技有限公司
 * @created 2017-11-09 13:32:00
 * @modifier 董朱旭
 * @updated 2017-11-09 13:32:00
 * @description 处理请求的参数
 */
public class RequstUtil {

    /**
     * 获取前端传来的信息
     * @author 董朱旭
     * @time 2017/11/9
     * @CopyRight 杭州微财网络科技有限公司
     * @param request
     * @return java.lang.String
     */
    public static String getRequstUrl(HttpServletRequest request,Map<String,String> map,Boolean isPost){
        String url=request.getRequestURL().toString().substring(
                request.getRequestURL().toString().indexOf(
                        request.getServletPath().toString()
                )
        ).substring(1);
        if(isPost){
            dealMultiValueMap(request,map);
        }else{
            url+=dealUrl(request);
        }
        return "http://"+url;
    }

    /**
     * @description 处理 get 请求的情况
     * @author 董朱旭
     * @time 2017/11/9
     * @CopyRight 杭州微财网络科技有限公司
     * @param request
     * @return java.lang.String
     */
    private static String dealUrl(HttpServletRequest request){
        String param=new String();
        Enumeration enu=request.getParameterNames();
        while(enu.hasMoreElements()){
            String paraName=(String)enu.nextElement();
            param+=paraName+"="+request.getParameter(paraName)+"&";
        }
        return StringUtils.isNotBlank(param)?"?"+param.substring(0,param.length()-1):"";
    }

    /**
     * 处理 post 或者 put 请求
     * @author 董朱旭
     * @time 2017/11/9
     * @CopyRight 杭州微财网络科技有限公司
     * @param request
     * @param map
     * @return void
     */
    private static void dealMultiValueMap(HttpServletRequest request,Map<String,String> map){

        Enumeration enu=request.getParameterNames();
        while(enu.hasMoreElements()){
            String paraName=(String)enu.nextElement();
            map.put(paraName,request.getParameter(paraName));
        }
    }
}
