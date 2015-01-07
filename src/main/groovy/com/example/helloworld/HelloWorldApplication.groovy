package com.example.helloworld

import io.dropwizard.Application
import io.dropwizard.setup.Bootstrap
import io.dropwizard.setup.Environment
import com.example.helloworld.resources.HelloWorldResource
import com.example.helloworld.health.TemplateHealthCheck

class HelloWorldApplication extends Application<HelloWorldConfiguration> {
    static void main(String[] args) throws Exception {
        new HelloWorldApplication().run(args)
    }

    @Override
    String getName() {
        "hello-world"
    }

    @Override
    void initialize(Bootstrap<HelloWorldConfiguration> bootstrap) {
        // nothing to do yet
    }

    @Override
    void run(HelloWorldConfiguration configuration,
                    Environment environment) {
        final HelloWorldResource resource = new HelloWorldResource(
                configuration.getTemplate(),
                configuration.getDefaultName()
        )
        final TemplateHealthCheck healthCheck =
                new TemplateHealthCheck(configuration.getTemplate())
        environment.healthChecks().register("template", healthCheck)
        environment.jersey().register(resource)
    }
}
