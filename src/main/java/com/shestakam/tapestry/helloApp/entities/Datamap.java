package com.shestakam.tapestry.helloApp.entities;

import com.shestakam.tapestry.helloApp.entities.auto._Datamap;

public class Datamap extends _Datamap {

    private static Datamap instance;

    private Datamap() {}

    public static Datamap getInstance() {
        if(instance == null) {
            instance = new Datamap();
        }

        return instance;
    }
}
