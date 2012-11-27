package org.github.jkuperus.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author Jelmer Kuperus
 */
public class ServeStaticPageFilter implements Filter {

    private static final String[] excludePaths = { "/css", "/img/", "/js", "/lib", "/partials", "/resources" };

    @Override
    public void init(FilterConfig config) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest servletRequest = (HttpServletRequest) request;
        if (shouldForward(servletRequest)) {
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        } else {
            chain.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {

    }

    protected boolean shouldForward(HttpServletRequest request) {
        String uri = request.getServletPath();
        for (String excludePath : excludePaths) {
            if (uri.startsWith(excludePath)) {
                return false;
            }
        }
        return true;
    }
}
