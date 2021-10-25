package org.example.entity;

public class Wiskey extends Alcohol{
    public Wiskey(double alcoholByVolume) {
        super(alcoholByVolume);
    }

    @Override
    public String toString() {
        return "It's a wiskey!";
    }
}
