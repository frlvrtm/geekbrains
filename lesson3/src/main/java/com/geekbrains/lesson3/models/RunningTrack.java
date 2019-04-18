package com.geekbrains.lesson3.models;

import com.geekbrains.lesson3.interfaces.Rival;

public class RunningTrack extends Let {

    private int length;

    public RunningTrack(int length) {
        this.length = length;
    }

    @Override
    String doIt(Rival rival) {
        return rival.run(length);
    }
}
