package com.ft.mustachemods.noncache;


import com.github.mustachejava.DefaultMustacheFactory;
import com.github.mustachejava.Mustache;
import com.github.mustachejava.MustacheException;
import com.google.common.base.Charsets;
import io.dropwizard.views.View;
import io.dropwizard.views.ViewRenderer;

import javax.ws.rs.WebApplicationException;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.nio.charset.Charset;
import java.util.Locale;

public class NonCachingMustacheViewRenderer implements ViewRenderer {

    @Override
    public boolean isRenderable(View view) {
        return view.getTemplateName().endsWith(".mustache");
    }

    @Override
    public void render(View view, Locale locale, OutputStream output)
            throws IOException, WebApplicationException {
        try {
            final Mustache template = new DefaultMustacheFactory() {
                @Override
                public Reader getReader(String resourceName) {
                    final InputStream is = getClass().getResourceAsStream(resourceName.replace("\\", "/"));
                    if (is == null) {
                        throw new MustacheException("Template " + resourceName + " not found");
                    }
                    return new BufferedReader(new InputStreamReader(is, Charsets.UTF_8));
                }
            }.compile(view.getTemplateName());

            final Charset charset = view.getCharset().or(Charsets.UTF_8);
            OutputStreamWriter writer = new OutputStreamWriter(output, charset);
            try{
                template.execute(writer, view);
            }finally {
                writer.close();
            }

        } catch (Exception e) {
            throw new FileNotFoundException("Template " + view.getTemplateName() + " not found.");
        }
    }
}
