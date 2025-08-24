package pokemon.view.backend.Logger;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class LoggerEachRequest extends OncePerRequestFilter{

    private static final Logger log=LoggerFactory.getLogger(LoggerEachRequest.class);

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
         long startTime = System.currentTimeMillis();

        try {
            log.info("➡️ {} {} from {}", request.getMethod(), request.getRequestURI(), request.getRemoteAddr());
            filterChain.doFilter(request, response);
        } finally {
            long duration = System.currentTimeMillis() - startTime;
            log.info("⬅️ {} {} completed in {} ms with status {}",
                    request.getMethod(),
                    request.getRequestURI(),
                    duration,
                    response.getStatus());
        }

    }
    
}
