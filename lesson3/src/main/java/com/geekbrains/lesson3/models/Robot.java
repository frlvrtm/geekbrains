package com.geekbrains.lesson3.models;

import com.geekbrains.lesson3.interfaces.Rival;

public class Robot implements Rival {

    private String name;
    private int maxRunDistance;
    private boolean active;

    public Robot(String name) {
        this.name = name;
        this.maxRunDistance = 5000;
        this.active = true;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMaxRunDistance() {
        return maxRunDistance;
    }

    public void setMaxRunDistance(int maxRunDistance) {
        this.maxRunDistance = maxRunDistance;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public String run(int distance) {
        if (distance <= maxRunDistance) {
            return (getName() + " пробежал дистанцию");
        } else {
            active = false;
            return (getName() + " не справился с дистанцией");
        }
    }

    @Override
    public String jump(double height) {
        active = false;
        return (getName() + " не умеет прыгать!");
    }

    @Override
    public boolean isOnDistance() {
        return active;
    }
}
