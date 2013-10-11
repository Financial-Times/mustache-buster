package com.ft.mustachemods;

import com.yammer.dropwizard.Bundle;
import com.yammer.dropwizard.config.Bootstrap;
import com.yammer.dropwizard.config.Environment;
import com.yammer.dropwizard.views.ViewBundle;

public class SwitchableMustacheViewBundle implements Bundle {

    public SwitchableMustacheViewBundle(){
    }

	@Override
	public void initialize(Bootstrap<?> bootstrap) {
        String mode = System.getProperty("mode");

        if(mode != null && mode.equalsIgnoreCase("dev")){
            bootstrap.addBundle(new NonCachingMustacheViewBundle());
        }else{
            bootstrap.addBundle(new ViewBundle());
        }
    }

	@Override
	public void run(Environment environment) {
    }

}
