package com.geekbrains.lesson3.models;

import com.geekbrains.lesson3.interfaces.Rival;

public class Course {

    private Let[] lets;

    public Course(Let... lets) {
        this.lets = lets;
    }

    public void doIt(Team team) {
        Rival[] rival = team.getRivals();
        for (Rival r : rival) {
            for (Let o : lets) {
                team.setResults(o.doIt(r));
                if (!r.isOnDistance()) {
                    break;
                }
            }
        }
    }
}
