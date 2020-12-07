package org.sash.funqy;

import io.quarkus.funqy.Funq;

public class PrimitiveFunctions {

    @Funq()
    public String sash() {
        System.out.println("sash Primitive Function called");
        return "Hello Sash";
    }

    @Funq("lower")
    public String toLowerCase(String val) {
        System.out.println("inside toLowerCase");
        return val.toLowerCase();
    }

    @Funq("double")
    public int doubleIt(int val) {
        return val + val;
    }


}
