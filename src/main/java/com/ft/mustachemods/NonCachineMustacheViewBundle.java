package com.ft.mustachemods;

import com.yammer.dropwizard.Bundle;
import com.yammer.dropwizard.config.Bootstrap;
import com.yammer.dropwizard.config.Environment;

public class NonCachineMustacheViewBundle implements Bundle {

	@Override
	public void initialize(Bootstrap<?> bootstrap) {
	}

	@Override
	public void run(Environment environment) {
		environment.addResource(
                new NonCachingMustacheBodyWriter());
	}
}
