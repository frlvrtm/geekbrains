package com.geekbrains.lesson3;

import com.geekbrains.lesson3.models.*;

public class Main {
    public static void main(String[] args) {
        Course course = new Course(new RunningTrack(800), new Wall(2));
        Team team = new Team(new Cat("Barsik"), new Human("Jack"), new Robot("R2-D2"));
        course.doIt(team);
        team.Results();
    }
}
