package org.example.entity;

public class Vodka extends Alcohol{
    public Vodka(double alcoholByVolume) {
        super(alcoholByVolume);
    }

    @Override
    public String toString() {
        return "It's a vodka!";
    }
}
