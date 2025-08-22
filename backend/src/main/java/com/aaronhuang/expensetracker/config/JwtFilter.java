package com.aaronhuang.expensetracker.config;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.context.ApplicationContext;
import com.aaronhuang.expensetracker.service.JWTService;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtFilter extends OncePerRequestFilter{ //every request will pass through this filter
    @Autowired
    private JWTService jwtService;

    @Autowired
    ApplicationContext context;

    @Override //implementing the abstract method from OncePerRequestFilter
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
            // Bearer eyJhGc........ we need to extract the actual token and remove the "Bearer " part        
        String authHeader = request.getHeader("Authorization");// get the header we need
        // authHeader has the Bearer eyJhGc..
        String token= null;
        String userEmail = null;

        if(authHeader != null && authHeader.startsWith("Bearer ")){ // check if the header is not null and starts with Bearer
            token = authHeader.substring(7); // remove the "Bearer " part, start at index 7
            userEmail = jwtService.extractUserEmail(token); // extract the user email from the toke
        }

        if(userEmail != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            UserDetails userDetails= context.getBean(UserDetailsService.class).loadUserByUsername(userEmail);
            
            if(jwtService.validateToken(token, userDetails)){
                UsernamePasswordAuthenticationToken authtoken=
                    new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                authtoken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(authtoken); // set the authentication into the chain
            }
        }
        filterChain.doFilter(request, response); // pass it to the next filter in the chain 
    }
    
}
