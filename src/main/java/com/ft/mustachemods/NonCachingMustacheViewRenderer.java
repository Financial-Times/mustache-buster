package com.ft.mustachemods;

import com.github.mustachejava.DefaultMustacheFactory;
import com.github.mustachejava.Mustache;
import com.github.mustachejava.MustacheException;
import com.google.common.base.Charsets;
import com.google.common.util.concurrent.UncheckedExecutionException;
import com.yammer.dropwizard.views.View;
import com.yammer.dropwizard.views.ViewRenderer;

import javax.ws.rs.WebApplicationException;
import java.io.*;
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
			final Mustache template = new DefaultMustacheFactory(){
			    @Override
			    public Reader getReader(String resourceName) {
			        final InputStream is = getClass().getResourceAsStream(resourceName);
			        if (is == null) {
			            throw new MustacheException("Template " + resourceName + " not found");
			        }
			        return new BufferedReader(new InputStreamReader(is, Charsets.UTF_8));
			    }
			}.compile(view.getTemplateName());

			final Charset charset = view.getCharset().or(Charsets.UTF_8);
			try (OutputStreamWriter writer = new OutputStreamWriter(output,
					charset)) {
				template.execute(writer, view);
			}
		} catch (UncheckedExecutionException | MustacheException ignored) {
			throw new FileNotFoundException("Template "
					+ view.getTemplateName() + " not found.");
		}
	}
}
