package com.aem.training.site.core.models;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import java.util.Locale;

@Model(adaptables = Resource.class)
public class NewHelloWorldModel {

    @ValueMapValue
    private String text;

    public String getText() {
        return text.toUpperCase();
    }
}
