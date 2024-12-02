package com.kodilla.game;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.SQLOutput;
import java.util.Random;
import java.util.Scanner;

@SpringBootApplication
public class GameApplication {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();


        String[] option = {"Kamień", "Papier", "Nożyce"};

        System.out.println("Rozpocząłeś gre w papier kamień nożyce ! ");
        System.out.println("Podaj liczbe gier: ");
        int rounds = sc.nextInt();


        int usersWins = 0;
        int compWins = 0;
        for (int round = 1; round <= rounds; round++) {
            System.out.println("\nRunda " + round + "/" + rounds);
            System.out.println("Wpisz: 0 - Kamień, 1 - Papier, 2 - Nożyce");


            System.out.print("Twój wybór: ");
            int userChoice = sc.nextInt();

            if (userChoice < 0 || userChoice > 2) {
                System.out.println("Błędny wybór, popraw swój wybór");
                round--;
                continue;

            }

            int compChoice = rand.nextInt(3);

            System.out.println("Twój wybór: " + option[userChoice]);
            System.out.println("Wybór komputera: " + option[compChoice]);

            if (userChoice == compChoice) {
                System.out.println("Remis");
            } else if ((userChoice == 0 && compChoice == 2) ||
                    (userChoice == 1 && compChoice == 0) ||
                    (userChoice == 2 && compChoice == 1)) {
                System.out.println("Wygrałęs");
                usersWins++;
            } else {
                System.out.println("Przegrałeś");
                compWins++;
            }


        }
        System.out.println("WYGRANYM ZOSTAŁ >>>>> !!");
        System.out.println("Użytkownik wygrał: " + usersWins);
        System.out.println("Komputer wygrał: " + compWins);

        if (usersWins > compWins) {
            System.out.println("Użytkownik wygrał!! - z " + usersWins + "wygranymi");
        } else {
            System.out.println("Komp wygrał!! - z " + compWins + "wygranymi");

        }
    }
}
