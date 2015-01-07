package com.example.helloworld

import io.dropwizard.Configuration
import com.fasterxml.jackson.annotation.JsonProperty
import org.hibernate.validator.constraints.NotEmpty

class HelloWorldConfiguration extends Configuration {
    @NotEmpty
    @JsonProperty
    final String defaultName = "Stranger"

    @NotEmpty
    @JsonProperty
    final String template
}
