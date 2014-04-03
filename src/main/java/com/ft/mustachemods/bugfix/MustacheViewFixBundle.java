package com.ft.mustachemods.bugfix;

import com.codahale.metrics.MetricRegistry;
import com.google.common.collect.ImmutableList;
import io.dropwizard.Bundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import io.dropwizard.views.ViewMessageBodyWriter;
import io.dropwizard.views.ViewRenderer;

public class MustacheViewFixBundle implements Bundle {

	@Override
	public void initialize(Bootstrap<?> bootstrap) {
	}

	@Override
	public void run(Environment environment) {
        final ViewRenderer renderer = new MustacheViewFixRenderer();
        ViewMessageBodyWriter viewMessageBodyWriter = new ViewMessageBodyWriter(new MetricRegistry(), ImmutableList.of(renderer));
        environment.jersey().register(viewMessageBodyWriter);
	}
}
