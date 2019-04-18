package com.geekbrains.lesson3.models;

import com.geekbrains.lesson3.interfaces.Rival;

public class Wall extends Let {

    private double heigth;

    public Wall(double heigth) {
        this.heigth = heigth;
    }

    @Override
    String doIt(Rival rival) {
        return rival.jump(heigth);
    }
}
