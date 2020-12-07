package org.sash.getting.started.knative;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class GreetingService {

    public String greeting(String name) {
        return "Knative hello " + name;
    }

}