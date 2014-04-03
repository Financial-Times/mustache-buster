package com.ft.mustachemods.bugfix;

import com.github.mustachejava.DefaultMustacheFactory;
import com.github.mustachejava.MustacheException;
import com.google.common.base.Charsets;
import io.dropwizard.views.View;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class PerClassMustacheFixFactory  extends DefaultMustacheFactory {

    private final Class<? extends View> klass;

    PerClassMustacheFixFactory(Class<? extends View> klass) {
        this.klass = klass;
    }

    @Override
    public Reader getReader(String resourceName) {
        //Fix the path name since a bug in mustache.java (0.8.12 to 0.8.14)
        final InputStream is = klass.getResourceAsStream(resourceName.replace("\\", "/"));
        if (is == null) {
            throw new MustacheException("Template " + resourceName.replace("\\", "/") + " not found");
        }
        return new BufferedReader(new InputStreamReader(is, Charsets.UTF_8));
    }
}

