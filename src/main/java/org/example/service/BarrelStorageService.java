package org.example.service;
import org.example.entity.Barrel;
import org.example.entity.Label;

import java.util.*;


//сервис, выдающий бочки
public class BarrelStorageService {
    Barrel label;
    private final HashSet<Barrel> barrels = new HashSet<>();    //множество

    public void addBarrel(Barrel barrel) {
        barrels.add(barrel);
        System.out.println(barrel);
    }

    //достать бочку
//    1) достать бочку по этикетке. Если такой бочки нет - выдать ошибку с подробным описанием.
//    после этого данная бочка в погребе, соответственно, исчезает
    public Set<Barrel> getBarrel(Barrel barrel) {
        //вывод элемента который имеет данную этикетку
        barrel.getLabel();
        //если бочки с такой этикеткой нет, то выдать ошибку
        if (barrels.contains(barrel) == false){
            System.out.println("Error. Barrel with this label is not exists!");
        }else {
            System.out.println(barrel);
            barrels.remove(barrel);
        }
        return barrels;
    }

    //положить бочку
    //2) положить бочку с этикеткой. Если такая этикетка есть - выдать ошибку с подробным описанием
    public void saveBarrel(Barrel barrel){
        if (barrels.contains(barrel)){  //если элемент c такой этикеткой найден
            System.out.println("Error: This label is already exists!");
        }else {
            barrels.add(barrel);
            System.out.println("Adding barrel: " + barrel);
        }
    }

//    3) Достать все бочки из погреба. Погреб остаётся после этого пустым


//    4) Выдать список всех этикеток (соотвественно, погреб не изменяется после этого)

    @Override
    public String toString() {
        return "BarrelStorageService{" +
                "barrels=" + barrels +
                '}';
    }
}
