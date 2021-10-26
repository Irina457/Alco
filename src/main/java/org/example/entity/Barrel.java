package org.example.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

//класс бочка
@AllArgsConstructor
@Setter
@Getter
public class Barrel{
    private final double size;      //размер бочки
    private Alcohol alcohol;
    private double currentFiling;   //текущее заполнение

    @Override
    public String toString() {
        return "Barrel{" +
                "size=" + size +
                ", alcohol=" + alcohol +
                ", currentFiling=" + currentFiling +
//                ", label='" + label + '\'' +
                '}';
    }
}
