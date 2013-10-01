package com.ft.mustachemods;

import com.codahale.dropwizard.Bundle;
import com.codahale.dropwizard.setup.Bootstrap;
import com.codahale.dropwizard.setup.Environment;

public class NonCachineMustacheViewBundle implements Bundle {

	@Override
	public void initialize(Bootstrap<?> bootstrap) {
	}

	@Override
	public void run(Environment environment) {
		environment.jersey().register(
				new NonCachingMustacheBodyWriter(environment.metrics()));
	}
}
