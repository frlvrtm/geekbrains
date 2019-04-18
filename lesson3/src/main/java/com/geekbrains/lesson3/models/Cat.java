package com.geekbrains.lesson3.models;

import com.geekbrains.lesson3.interfaces.Rival;

public class Cat implements Rival {

    private String name;
    private int maxRunDistance;
    private double maxJumpHeight;
    private boolean active;

    public Cat(String name) {
        this.name = name;
        this.maxRunDistance = 200;
        this.maxJumpHeight = 2.7;
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

    public double getMaxJumpHeight() {
        return maxJumpHeight;
    }

    public void setMaxJumpHeight(double maxJumpHeight) {
        this.maxJumpHeight = maxJumpHeight;
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
        if (height <= maxJumpHeight) {
            return (getName() + " совершил прыжок");
        } else {
            active = false;
            return (getName() + " не справился с препятствием");
        }
    }

    @Override
    public boolean isOnDistance() {
        return active;
    }
}
