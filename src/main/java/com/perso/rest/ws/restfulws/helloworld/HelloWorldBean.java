package com.perso.rest.ws.restfulws.helloworld;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class HelloWorldBean {
    private String message;

    public HelloWorldBean(String message) {
        this.message=message;

    }

}
