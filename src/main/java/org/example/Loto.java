package org.example;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class Loto {
    private List<Toys> toys;
    private List<Toys> prizeToys;

    public Loto() {
        toys = new ArrayList<>();
        prizeToys = new ArrayList<>();
    }

    public void addToy(Toys toy) {
        toys.add(toy);
    }

    public void updateWeight(int toyId, double newWeight) {
        for (Toys toy : toys) {
            if (toy.getId() == toyId) {
                toy.setWeight(newWeight);
                break;
            }
        }
    }

    public void playLottery() {
        Random random = new Random();
        for (Toys toy : toys) {
            int randomNum = random.nextInt(100) + 1;
            if (randomNum <= toy.getWeight()) {
                prizeToys.add(toy);
                toy.setQuantity(toy.getQuantity() - 1);
            }
        }
    }

    public Toys getPrizeToy() {
        if (!prizeToys.isEmpty()) {
            Toys prizeToy = prizeToys.get(0);
            prizeToys.remove(0);
            return prizeToy;
        }
        return null;
    }

    public void displayRemainingToys() {
        for (Toys toy : toys) {
            System.out.println("Игрушка: " + toy.getName() + ", Остаток: " + toy.getQuantity());
        }
    }

    public void savePrizeToyToFile(Toys toy) {
        try (FileWriter writer = new FileWriter("prize_toys.txt", true)) {
            writer.write(toy.getName() + "\n");
        } catch (IOException e) {
            System.out.println("Ошибка при записи в файл.");
            e.printStackTrace();
        }
    }

}


