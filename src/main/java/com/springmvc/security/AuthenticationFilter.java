//package com.springmvc.security;
//
//import java.io.IOException;
//import java.util.ArrayList;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//
//public class AuthenticationFilter extends UsernamePasswordAuthenticationFilter {
//
//	public AuthenticationFilter(AuthenticationManager authenticationManager) {
//		super.setAuthenticationManager(authenticationManager);
//    }
//	
//    @Override
//    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) {
//        try {
//            UserAuthenticationRequest user = new ObjectMapper().readValue(request.getInputStream(), UserAuthenticationRequest.class);
//
//            return getAuthenticationManager().authenticate(
//                new UsernamePasswordAuthenticationToken(
//                    user.getUsername(),
//                    user.getPassword(),
//                    new ArrayList<>()
//                )
//            );
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//    }
//}