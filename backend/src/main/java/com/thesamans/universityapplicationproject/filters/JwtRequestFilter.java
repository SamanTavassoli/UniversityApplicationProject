package com.thesamans.universityapplicationproject.filters;

import com.google.common.base.Enums;
import com.google.common.base.Objects;
import com.thesamans.universityapplicationproject.model.users.User;
import com.thesamans.universityapplicationproject.model.users.UserType;
import com.thesamans.universityapplicationproject.services.MyUserDetailsService;
import com.thesamans.universityapplicationproject.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JwtRequestFilter extends OncePerRequestFilter {

    @Autowired
    private MyUserDetailsService userDetailsService;

    @Autowired
    private JwtUtil jwtUtil;

    /**
     * Authenticates users if they have provided a valid JWT token
     * It creates a UsernamePasswordAuthenticationToken if the user has been authenticated
     * @param request request object
     * @param response response object
     * @param filterChain to call next filter in the filter chain after the end of this filter
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        // look for an authorization
        final String authorizationHeader = request.getHeader("Authorization");

        String username = null;
        String jwt = null;

        // checking for jwt if we have "Bearer "
        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            jwt = authorizationHeader.substring(7); // after "Bearer "
            username = jwtUtil.extractUsername(jwt); // we get 'a' username, not sure if it is the right one
        }

        if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {

            // fetch user details to check if we extracted a correct username
            UserDetails userDetails = this.userDetailsService.loadUserByUsername(username);

            // we finally check if the jwt returns the same username as userDetails
            // this would check for more things if there were more elements other than username
            if (jwtUtil.validateTokens(jwt, userDetails)) {

                // this is how we say that someone has been authenticated
                UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
                        userDetails, null, userDetails.getAuthorities());

                // auth token saves details about the request
                usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

                // "Security Context Holder is where Spring stores the details of who is authenticated"
                // Get context for current user and set the authentication
                SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
            }
        }

        filterChain.doFilter(request, response);
    }
}
