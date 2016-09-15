package com.spring.context;

import javax.servlet.ServletContext;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.web.context.ServletContextAware;

/**
 * @author <a href="mailto:sunil.pulugula@wavemaker.com">Sunil Kumar</a>
 * @since 14/9/16
 */
public class ContextAwareBean implements ServletContextAware,ApplicationContextAware {

    private ApplicationContext applicationContext;

    private ServletContext servletContext;

    @Override
    public void setApplicationContext(final ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    @Override
    public void setServletContext(final ServletContext servletContext) {
       this.servletContext = servletContext;
    }

    public ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    public ServletContext getServletContext() {
        return servletContext;
    }
}
