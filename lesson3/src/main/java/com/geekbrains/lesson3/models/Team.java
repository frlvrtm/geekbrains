package com.geekbrains.lesson3.models;

import com.geekbrains.lesson3.interfaces.Rival;

public class Team {

    private Rival[] rivals;
    private StringBuilder results;

    public Team(Rival... rivals) {
        this.rivals = rivals;
        this.results = new StringBuilder();
    }

    public Rival[] getRivals() {
        return rivals;
    }

    public void setRivals(Rival[] rivals) {
        this.rivals = rivals;
    }

    public StringBuilder getResults() {
        return results;
    }

    public void setResults(String result) {
        results.append(result).append("\n");
    }

    public void Results() {
        System.out.print(results);
    }
}
