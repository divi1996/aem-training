package com.aem.training.site.core.services;

import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;

@ObjectClassDefinition(name = "Sample OSGi Configuration", description = "Sample OSGi Configuration Description")
public @interface SampleOsgiConfiguration {

    @AttributeDefinition
    public String getPath();
}
