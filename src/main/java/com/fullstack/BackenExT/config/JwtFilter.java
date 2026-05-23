package com.fullstack.BackenExT.config;

import com.fullstack.BackenExT.service.CustomUserDetailsService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.hibernate.validator.constraints.CodePointLength;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.servlet.HandlerExceptionResolver;

import java.io.IOException;
@Component
@RequiredArgsConstructor
public class JwtFilter extends OncePerRequestFilter {

    private final JwtUtil jwtUtil;
    private final HandlerExceptionResolver handlerExceptionResolver;
    private final CustomUserDetailsService customUserDetailsService;
    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain)
            throws ServletException, IOException {

       try {
           String authHeader = request.getHeader("Authorization");


           String token=null, username = null;

           if (authHeader != null && authHeader.startsWith("Bearer ")) {

               token = authHeader.substring(7);

               username = jwtUtil.extractUsername(token);
           }

           if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {


               UserDetails userDetails = customUserDetailsService.loadUserByUsername(username);

               if (jwtUtil.validateToken(username, userDetails, token)) {
                   UsernamePasswordAuthenticationToken authToken =
                           new UsernamePasswordAuthenticationToken(userDetails
                                   , null, userDetails.getAuthorities());

                   authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

                   SecurityContextHolder.getContext().setAuthentication(authToken);

                   boolean valid =
                           jwtUtil.validateToken(username, userDetails, token);

                   System.out.println(valid);

                   System.out.println(authHeader);
                   System.out.println(token);
                   System.out.println(username);
               }
           }


           filterChain.doFilter(request, response);

           System.out.println("JWT FILTER EXECUTED");
       }catch (Exception e){
           handlerExceptionResolver.resolveException(request,response,null,e);
       }

    }
}
