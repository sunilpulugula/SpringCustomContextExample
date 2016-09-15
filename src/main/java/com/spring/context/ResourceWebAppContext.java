package com.spring.context;

import org.springframework.web.context.support.XmlWebApplicationContext;

/**
 * @author <a href="mailto:sunil.pulugula@wavemaker.com">Sunil Kumar</a>
 * @since 14/9/16
 */
public class ResourceWebAppContext extends XmlWebApplicationContext{

    public ResourceWebAppContext(final ContextAwareBean contextAwareBean) {
        setId("Resource");
        setParent(contextAwareBean.getApplicationContext());
        setClassLoader(this.getClassLoader());
        setServletContext(contextAwareBean.getServletContext());
        setDisplayName("Resrouce context");
        setConfigLocations(new String[]{"/WEB-INF/ResourcesServletContext.xml"});
        refresh();
    }

}
