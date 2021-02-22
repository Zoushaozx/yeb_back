package com.zoux.server.config.security.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * jwt登陆授权过滤器
 */
public class JwtAuthorizationTokenFilter extends OncePerRequestFilter {
    @Value("${jwt.tokenHeader}")
    private String tokenHeader;
    @Value("${jwt.tokenHead}")
    private String tokenHead;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        //判断key能不能拿到value
        String authHeader = httpServletRequest.getHeader(tokenHeader);
        //判断这个value是不是以tokenHead开头的
        if (null != authHeader && authHeader.startsWith(tokenHead)) {
            //进行字符串截取
            String authToken = authHeader.substring(tokenHead.length());
            //jwt根据token获取用户名
            String username = jwtTokenUtil.getUserNameFromToken(authToken);
            //判断用户名是否为空，同时检查springsecurity全局上下文找不到用户对象，即未登录
            if (null != username && null == SecurityContextHolder.getContext().getAuthentication()) {
                //                调用重写的UserDetailsService
                //获取userdetails，相当于登陆了
                UserDetails userDetails = userDetailsService.loadUserByUsername(username);
                //判断token是否有效，有效就将token重新放入用户对象
                if (jwtTokenUtil.validateToken(authToken, userDetails)) {
                    //重新设置用户对象,更新荷载
                    UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                    //重新设置用户对象，更新details
                    authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(httpServletRequest));
                    //设置springsecurity全局上下文
                    SecurityContextHolder.getContext().setAuthentication(authenticationToken);

                }
            }
        }
        //放行
        filterChain.doFilter(httpServletRequest,httpServletResponse);
    }
}
