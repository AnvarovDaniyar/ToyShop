package org.example;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Loto loto = new Loto();
        loto.addToy(new Toys(1, "Машинка", 25, 15));
        loto.addToy(new Toys(2, "Барби", 15, 30));
        loto.addToy(new Toys(3, "Плюшевая свинка", 45, 35));

        loto.updateWeight(1, 35);

        loto.playLottery();

        Toys prizeToy = loto.getPrizeToy();
        if (prizeToy != null) {
            System.out.println("Выиграна игрушка: " + prizeToy.getName());
            loto.savePrizeToyToFile(prizeToy);

        } else {
            System.out.println("Нет доступных призовых игрушек.");
        }

        loto.displayRemainingToys();
    }
}
