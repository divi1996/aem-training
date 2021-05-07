package com.aem.training.site.core.services.impl;

import com.aem.training.site.core.services.SampleOsgiConfiguration;
import com.aem.training.site.core.services.SampleOsgiService;
import org.apache.commons.lang3.StringUtils;
import org.apache.sling.api.resource.LoginException;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ResourceResolverFactory;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.metatype.annotations.Designate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

@Component(service = SampleOsgiService.class)
@Designate(ocd = SampleOsgiConfiguration.class)
public class SampleOsgiServiceImpl implements SampleOsgiService {

    private static final Logger log = LoggerFactory.getLogger(SampleOsgiServiceImpl.class);

    String path = StringUtils.EMPTY;

    @Reference
    ResourceResolverFactory resourceResolverFactory;

    @Activate
    protected void activateOrModified(SampleOsgiConfiguration sampleOsgiConfiguration) {
        path = sampleOsgiConfiguration.getPath();
        System.out.println(path);
    }

    @Override
    public String getResourceType() {
        return "";
    }

    private ResourceResolver getResourceResolver(final ResourceResolverFactory resourceResolverFactory,
                                                 final String systemUserName) {
        ResourceResolver resourceResolver = null;

        if (null != resourceResolverFactory && null != systemUserName) {
            try {
                final Map<String, Object> authInfo = new HashMap<>();
                authInfo.put(ResourceResolverFactory.SUBSERVICE, systemUserName);
                resourceResolver = resourceResolverFactory.getResourceResolver(authInfo);
            }
            catch (final LoginException loginException) {
                log.error("Error occurred : " + loginException);
            }
        }
        return resourceResolver;
    }
}
