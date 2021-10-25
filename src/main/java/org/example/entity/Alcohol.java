package org.example.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public abstract class Alcohol {
    private final double alcoholByVolume;     //градус алоголя

    @Override
    public abstract String toString();
}
