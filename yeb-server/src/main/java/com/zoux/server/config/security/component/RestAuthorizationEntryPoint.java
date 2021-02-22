package com.zoux.server.config.security.component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zoux.server.pojo.RespBean;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 当未登陆或者token失效时访问接口时，自定义的返回结果
 */
@Component
public class RestAuthorizationEntryPoint implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
        //通过response设置字符集
        httpServletResponse.setCharacterEncoding("UTF-8");
        //设置数据交流格式
        httpServletResponse.setContentType("application/json");
        //获取输出流
        PrintWriter out = httpServletResponse.getWriter();
        //自定义返回类型
        RespBean bean = RespBean.error("未登陆，请登录！！");
        bean.setCode(401);
        out.write(new ObjectMapper().writeValueAsString(bean));
        out.flush();
        out.close();
    }
}
