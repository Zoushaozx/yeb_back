package com.zoux.server.config.security.component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zoux.server.pojo.RespBean;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Component
public class RestfulAccessDeniedHandler implements AccessDeniedHandler {

    @Override
    public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AccessDeniedException e) throws IOException, ServletException {
        //通过response设置字符集
        httpServletResponse.setCharacterEncoding("UTF-8");
        //设置数据交流格式
        httpServletResponse.setContentType("application/json");
        //获取输出流
        PrintWriter out = httpServletResponse.getWriter();
        //自定义返回类型
        RespBean bean = RespBean.error("权限不足，请联系管理员！！");
        bean.setCode(403);
        out.write(new ObjectMapper().writeValueAsString(bean));
        out.flush();
        out.close();
    }
}
