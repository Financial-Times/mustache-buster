package com.ft.mustachemods;

import com.ft.mustachemods.bugfix.MustacheViewFixBundle;
import com.ft.mustachemods.noncache.NonCachingMustacheViewBundle;
import io.dropwizard.Bundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class SwitchableMustacheViewBundle implements Bundle {

    public SwitchableMustacheViewBundle(){
    }

	@Override
	public void initialize(Bootstrap<?> bootstrap) {
        String mode = System.getProperty("mode");

        if(mode != null && mode.equalsIgnoreCase("dev")){
            bootstrap.addBundle(new NonCachingMustacheViewBundle());
        }else{
            bootstrap.addBundle(new MustacheViewFixBundle());
        }
    }

	@Override
	public void run(Environment environment) {
    }

}
