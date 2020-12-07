package org.sash.funqy;

import io.quarkus.funqy.Funq;

import javax.inject.Inject;

public class GreetingFunction {

    @Inject
    GreetingService service;

    @Funq
    public Greeting greet(Friend friend) {
        Greeting greeting = new Greeting();
        System.out.println("Greet FunQ called");
        greeting.setMessage(service.greet(friend.getName()));
        return greeting;
    }
}
