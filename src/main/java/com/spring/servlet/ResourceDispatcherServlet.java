package com.spring.servlet;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.HandlerExecutionChain;
import org.springframework.web.servlet.HandlerMapping;

import com.spring.context.ContextAwareBean;
import com.spring.context.ResourceWebAppContext;

/**
 * @author <a href="mailto:sunil.pulugula@wavemaker.com">Sunil Kumar</a>
 * @since 14/9/16
 */
public class ResourceDispatcherServlet extends DispatcherServlet {

    private String contextUrl;

    /*@Override
    protected void doDispatch(HttpServletRequest request, HttpServletResponse response) throws Exception {

        String contextUrl = getContextUrl(request);
        if (contextUrl.startsWith("/resources")) {
            WebApplicationContext webApplicationContext = lookupContext(request);
            request.setAttribute(WEB_APPLICATION_CONTEXT_ATTRIBUTE, webApplicationContext);
        }
        super.doDispatch(request, response);
    }*/

    private WebApplicationContext lookupContext(HttpServletRequest request) {
        String contextUrl = getContextUrl(request);
        if (contextUrl.startsWith("/resources")) {
            ContextAwareBean contextAwareBean = (ContextAwareBean) getWebApplicationContext().getBean("contextAwareBean");
            return new ResourceWebAppContext(contextAwareBean);
        }
        return getWebApplicationContext();
    }

    public String getContextUrl(final HttpServletRequest request) {
        String servletPath = request.getContextPath() + request.getServletPath();
        return request.getRequestURI().substring(servletPath.length());
    }

    @Override
    protected HandlerExecutionChain getHandler(final HttpServletRequest request) throws Exception {
        ApplicationContext context = lookupContext(request);

        if (context != null) {
            Map<String, HandlerMapping> handlerMappingMap = context.getBeansOfType(HandlerMapping.class);
            for (HandlerMapping hm : handlerMappingMap.values()) {
                if (logger.isTraceEnabled()) {
                    logger.trace(
                            "Testing handler map [" + hm + "] in DispatcherServlet with name '" + getServletName() + "'");
                }
                HandlerExecutionChain handler = hm.getHandler(request);
                if (handler != null) {
                    return handler;
                }
            }
        }

        return null;
    }

}
