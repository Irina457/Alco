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
 */

import org.example.entity.*;
import org.example.service.BarrelStorageService;

import java.util.HashSet;

public class Application {
    public static void main(String[] args){
        //этикетки
        Label label1 = new Label("Шампань, урожай 1092 года");
        Label label2 = new Label("Jack Daniels");
        Label label3 = new Label("Самогон от соседа");
        Label label4 = new Label("Папино домашнее вино");


        //создание нового объекта погреб
        BarrelStorageService storageService = new BarrelStorageService();

        //создание бочек
        Barrel barrel1 = new Barrel(20,new Wine(15),20, label1);
        Barrel barrel2 = new Barrel(15,new Wiskey(40),50, label2);
        Barrel barrel3 = new Barrel(30,new Vodka(40),50, label3);
        Barrel barrel4 = new Barrel(10,new Wine(17),25, label4);

        //положить бочки в погреб
        storageService.addBarrel(barrel1);
        System.out.println("Этикетка бочки 1 " + barrel1.getLabel());
        storageService.addBarrel(barrel2);
        System.out.println("Этикетка бочки 2 " + barrel2.getLabel());
        storageService.addBarrel(barrel3);
        System.out.println("Этикетка бочки 3 " + barrel3.getLabel());

        //достать бочку
        storageService.getBarrel(barrel1);
        //погреб без взятой бочки
        System.out.println(storageService);

        //положить существующую бочку
        storageService.saveBarrel(barrel2);

        //положить новую бочку
        storageService.saveBarrel(barrel4);

        //вывести погреб
        System.out.println(storageService);
    }
}