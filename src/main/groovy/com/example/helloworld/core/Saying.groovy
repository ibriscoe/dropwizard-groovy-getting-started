package com.example.helloworld.core

import com.fasterxml.jackson.annotation.JsonProperty
import groovy.transform.TupleConstructor
import org.hibernate.validator.constraints.Length

@TupleConstructor
class Saying {

    @JsonProperty
    final long id

    @Length(max = 3)
    @JsonProperty
    final String content

    Saying() {
        // Jackson deserialization
    }
}
