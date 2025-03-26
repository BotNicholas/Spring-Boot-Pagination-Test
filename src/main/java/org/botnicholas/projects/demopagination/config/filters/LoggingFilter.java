package org.botnicholas.projects.demopagination.config.filters;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletRequestWrapper;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.stereotype.Component;
import org.springframework.util.StreamUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
@Slf4j
public class LoggingFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        long startTime = System.currentTimeMillis();

        String method = request.getMethod();
        String uri = request.getRequestURI();
        String queryString = request.getQueryString();
        String clientIp = request.getRemoteAddr();

        log.info("Incoming request {}: {}?{} from {}", method, uri,
                (queryString == null ? "" : queryString), clientIp);

//        try(InputStream is = request.getInputStream()) {
//            Unfortunately the original input stream (the request Body) is consumed when we read it this way, so it's impossible to work with it in the continuation...
//            ByteArrayOutputStream os = new ByteArrayOutputStream();
//            IOUtils.copy(is, os);
            //OR
//            byte[] ba =  StreamUtils.copyToByteArray(is);
//        }

//            BUT, we can create a HttpServletRequest class that will cache the request body and override corresponding methods to obtein input stream and Reqder.
//            Thus, this "consumed body" from the previous request will be saved and passed it next :D Just like this:
        var newReq = new CachedHttpServletRequest(request);

        log.info("REQUEST DATA: " + new String(newReq.getInputStream().readAllBytes()));

        filterChain.doFilter(newReq, response);

        long duration = System.currentTimeMillis() - startTime;
        int status = response.getStatus();

        log.info("Completed request {}: {} with status {} in {} ms", method, uri, status, duration);
    }
}
