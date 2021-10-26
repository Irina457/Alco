package org.example.service;
import org.example.entity.Barrel;
import org.example.entity.Label;

import java.util.*;

public class BarrelStorageService {
    private final Map<Label, Barrel> barrels = new HashMap<Label, Barrel>();

    //      1) достать бочку по этикетке. Если такой бочки нет - выдать ошибку с подробным описанием.
    //      после этого данная бочка в погребе, соответственно, исчезает
    public void getBarrel(Label label) {
        if (!barrels.containsKey(label)) {
            System.out.println("Ошибка! Бочки с такой этикеткой не существует!");
        } else {
            System.out.println("Взятая бочка: " + label + ", " + barrels.get(label));
            barrels.remove(label);
        }
    }

    //      2) положить бочку с этикеткой. Если такая этикетка есть - выдать ошибку с подробным описанием
    public void putBarrel(Label label, Barrel barrel) {
        if (barrels.containsKey(label)) {  //если элемент c такой этикеткой найден
            System.out.println("Ошибка! Такая этикетка уже существует!");
        } else {
            barrels.put(label, barrel);
            System.out.println("Добавленная бочка: " + label + ", " + barrel);
        }
    }

    //      3) Достать все бочки из погреба. Погреб остаётся после этого пустым
    public void getAllBarrels() {
        ArrayList<Barrel> barrel = new ArrayList<>(barrels.values());
        System.out.println("Бочки погреба: " + barrel);
        barrels.clear();
        System.out.println("Погреб пустой!");
    }

    //      4) Выдать список всех этикеток (соотвественно, погреб не изменяется после этого)
    public void getAllLabels() {
        Set<Label> label = barrels.keySet();
        System.out.println("Существующие этикетки: " + label);
    }

    @Override
    public String toString() {
        return "Погреб{" +
                "Бочки: " + barrels +
                '}';
    }
}