package com.ft.mustachemods.noncache;

import io.dropwizard.Bundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class NonCachingMustacheViewBundle implements Bundle {

	@Override
	public void initialize(Bootstrap<?> bootstrap) {
	}

	@Override
	public void run(Environment environment) {
        environment.jersey().register(new NonCachingMustacheBodyWriter());
	}
}
