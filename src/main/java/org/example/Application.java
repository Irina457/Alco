package org.example;
/* Необходимо немного переделать наш вчерашний "Винный погреб"
Заказчик хочет, чтоб рядом с каждой бочкой была уникальная этикетка, которая эту бочку обозначает
(например: "Шампань, урожай 1092 года", "Самогон от соседа" и т.д.)
И у погреба должны быть следующие методы:
1) достать бочку по этикетке. Если такой бочки нет - выдать ошибку с подробным описанием.
    после этого данная бочка в погребе, соответственно, исчезает
2) положить бочку с этикеткой. Если такая этикетка есть - выдать ошибку с подробным описанием
3) Достать все бочки из погреба. Погреб остаётся после этого пустым
4) Выдать список всех этикеток (соотвественно, погреб не изменяется после этого)
Темы для этого задания: Коллекции, Исключения, Циклы
Подсказка: Внимательно подумайте, в какой именно структуре стоит хранить эти бочки в погребе ))

BarrelStorageService - сервис, выдающий бочки
barrels - массив бочек
Barrel - бочка
Alcohol - абстарктный класс

HashMap - это карта ключ -> значение (ключ к значению), например, {a -> 1, b -> 2, c -> 2, d -> 1}
 */

import org.example.entity.*;
import org.example.service.BarrelStorageService;

import java.util.HashMap;
import java.util.Map;

public class Application {
    public static void main(String[] args){
        //этикетки
        Label label1 = new Label("Шампань, урожай 1092 года");
        Label label2 = new Label("Jack Daniels");
        Label label3 = new Label("Самогон от соседа");
        Label label4 = new Label("Папино домашнее вино");

        //создание бочек
        Barrel barrel1 = new Barrel(20,new Wine(15),20);
        Barrel barrel2 = new Barrel(15,new Wiskey(40),50);
        Barrel barrel3 = new Barrel(30,new Vodka(40),50);
        Barrel barrel4 = new Barrel(10,new Wine(17),25);

        //создание нового объекта погреб
        BarrelStorageService storageService = new BarrelStorageService();
        try {
            //добавление бочек с этикетками в погреб
            storageService.putBarrel(label1, barrel1);
            storageService.putBarrel(label2, barrel2);
            storageService.putBarrel(label3, barrel3);

            System.out.println("1 " + storageService);

            //выдать список всех этикеток
            System.out.println("Существующе этикетки: " + storageService.getAllLabels());

            System.out.println("2 " + storageService.getBarrel(label1));
            System.out.println("3 " + storageService);

            //достать бочку по этикетке еще раз
            System.out.println("4 " + storageService.getBarrel(label1));
            System.out.println("5 " + storageService);

            storageService.putBarrel(label1, barrel1);

            //добавление бочки с уже существующей этикеткой
            storageService.putBarrel(label2, barrel3);
            System.out.println();

            System.out.println(storageService);

            //достать бочку по этикетке
            storageService.getBarrel(label1);

            System.out.println(storageService);

            //достать бочку по несуществующей этикетке
            storageService.getBarrel(label4);
            System.out.println();

            //достать все бочки из погреба
            storageService.getAllBarrels();

            System.out.print(storageService);
        }catch (NotExistBarrelException | AlreadyExistsBarrelException e){
            System.err.println(e.getMessage());
        }
    }
}