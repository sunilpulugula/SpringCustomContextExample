package com.spring.resource.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.spring.resource.model.Resource;

/**
 * @author <a href="mailto:sunil.pulugula@wavemaker.com">Sunil Kumar</a>
 * @since 13/9/16
 */
@RestController
public class ResourcesController {

    @RequestMapping(value = "/resources", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Resource> listResources() {
        List<Resource> resources = new ArrayList<>();
        resources.add(new Resource("Resource1", "Resource1", 100));
        resources.add(new Resource("Resource2", "Resource2", 200));
        resources.add(new Resource("Resource3", "Resource3", 300));
        resources.add(new Resource("Resource4", "Resource4", 400));

        return resources;
    }
}
