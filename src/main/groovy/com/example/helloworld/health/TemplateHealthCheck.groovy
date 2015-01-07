package com.example.helloworld.health

import com.codahale.metrics.health.HealthCheck

// Groovy needs this import to avoid compiler error
import com.codahale.metrics.health.HealthCheck.Result

class TemplateHealthCheck extends HealthCheck {
    private final String template

    TemplateHealthCheck(String template) {
        this.template = template
    }

    @Override
    protected Result check() throws Exception {
        final String saying = String.format(template, "TEST")

        saying.contains("TEST") ?
                Result.healthy() : Result.unhealthy("template doesn't include a name")

    }
}