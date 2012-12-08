package org.github.jkuperus.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author Jelmer Kuperus
 */
public class ServeStaticPageFilter implements Filter {

    private static final String[] EXCLUDE_PATHS = { "/css", "/img/", "/js", "/lib", "/partials", "/resources" };
    private static final String STATIC_PAGE = "/index.jsp";

    @Override
    public void init(FilterConfig config) throws ServletException {
        // do nothing
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest servletRequest = (HttpServletRequest) request;
        if (shouldForward(servletRequest)) {
            request.getRequestDispatcher(STATIC_PAGE).forward(request, response);
        } else {
            chain.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {
        // do nothing
    }

    protected boolean shouldForward(HttpServletRequest request) {
        String uri = request.getServletPath();
        for (String excludePath : EXCLUDE_PATHS) {
            if (uri.startsWith(excludePath)) {
                return false;
            }
        }
        return true;
    }
}
