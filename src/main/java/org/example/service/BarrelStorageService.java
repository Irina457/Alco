package org.example.service;
import org.example.entity.AlreadyExistsBarrelException;
import org.example.entity.Barrel;
import org.example.entity.Label;
import org.example.entity.NotExistBarrelException;

import java.util.*;

public class BarrelStorageService {
    private final Map<Label, Barrel> barrels = new HashMap<>();

    //      1) достать бочку по этикетке. Если такой бочки нет - выдать ошибку с подробным описанием.
    //      после этого данная бочка в погребе, соответственно, исчезает
    public Barrel getBarrel(Label label) throws NotExistBarrelException {
        Barrel someBarrel;
        if (!barrels.containsKey(label)) {
            // если исключительная ситуация, то сгенерировать исключение
            throw new NotExistBarrelException("Ошибка! Бочки с такой этикеткой не существует!");
        } else {
            someBarrel = barrels.get(label);
            barrels.remove(label);
        }
        return someBarrel;
    }

    //      2) положить бочку с этикеткой. Если такая этикетка есть - выдать ошибку с подробным описанием
    public void putBarrel(Label label, Barrel barrel) throws AlreadyExistsBarrelException {
        if (barrels.containsKey(label)) {  //если элемент c такой этикеткой найден
            throw new AlreadyExistsBarrelException("Ошибка! Такая этикетка уже существует!");
        } else {
            barrels.put(label, barrel);
        }
    }

    //      3) Достать все бочки из погреба. Погреб остаётся после этого пустым
    public List<Barrel> getAllBarrels() {
        ArrayList<Barrel> allBarrels = new ArrayList<>(barrels.values());
        barrels.clear();
        System.out.println("Погреб пустой!");
        return allBarrels;
    }

    //      4) Выдать список всех этикеток (соотвественно, погреб не изменяется после этого)
    public Set<Label> getAllLabels() {
        return barrels.keySet();
    }

    @Override
    public String toString() {
        return "Погреб{" +
                "Бочки: " + barrels +
                '}';
    }
}