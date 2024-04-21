package dev.himbra.bankapplication.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.logging.Logger;

@Component
@AllArgsConstructor
public class JwtAuthFilter extends OncePerRequestFilter {
    private UserDetailsService userDetailsService;
    private JwtService jwtService;
   // private static final Logger logger= (Logger) LoggerFactory.getLogger(JwtAuthFilter.class);

    @Override
    protected void doFilterInternal(@NotNull HttpServletRequest request, @NotNull HttpServletResponse response, @NotNull FilterChain filterChain) throws ServletException, IOException {
         try {
                String jwt = paresJwt(request);

                if(jwt != null && jwtService.validateJwtToken(jwt)){
                    String username = jwtService.getUsernameFromJwtToken(jwt);
                    UserDetails userDetails= userDetailsService.loadUserByUsername(username);
                    UsernamePasswordAuthenticationToken authenticationToken= new UsernamePasswordAuthenticationToken(userDetails.getUsername(),null, userDetails.getAuthorities());
                    authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                    SecurityContextHolder.getContext().setAuthentication(authenticationToken);
                }
            }catch (Exception e){
              //  logger.config("Cannot set User Authentication :{} "+e);
            }
            filterChain.doFilter(request, response);
        }

        private String paresJwt(HttpServletRequest request){
            String headerAuth= request.getHeader("Authorization");
            if (StringUtils.hasText(headerAuth) && headerAuth.startsWith("Bearer ")){
                return headerAuth.substring(7);

            }
            return null;
        }
    }


