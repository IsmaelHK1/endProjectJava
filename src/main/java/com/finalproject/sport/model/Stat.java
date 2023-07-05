package com.finalproject.sport.model;

public class Stat {
    private int totalLoad;
    private int monotony;
    private int strain;
    private int fitness;
    private int acuteChronic;

    public Stat(int totalLoad, int monotony, int strain, int fitness, int acuteChronic){
        this.totalLoad = totalLoad;
        this.monotony = monotony;
        this.strain = strain;
        this.fitness = fitness;
        this.acuteChronic = acuteChronic;
    }

    public int getTotalLoad() {
        return totalLoad;
    }

    public void setTotalLoad(int totalLoad) {
        this.totalLoad = totalLoad;
    }

    public int getMonotony() {
        return monotony;
    }

    public void setMonotony(int monotony) {
        this.monotony = monotony;
    }

    public int getStrain() {
        return strain;
    }

    public void setStrain(int strain) {
        this.strain = strain;
    }

    public int getFitness() {
        return fitness;
    }

    public void setFitness(int fitness) {
        this.fitness = fitness;
    }

    public int getAcuteChronic() {
        return acuteChronic;
    }

    public void setAcuteChronic(int acuteChronic) {
        this.acuteChronic = acuteChronic;
    }
}

