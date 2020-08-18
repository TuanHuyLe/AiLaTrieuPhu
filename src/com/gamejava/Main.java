package com.gamejava;

import com.gamejava.adapter.Game;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Game game = new Game();
        String choice = "Y";
        while (choice.equals("Y")) {
            game.run();
            System.out.println("Ban muon choi lai (Y/N): ");
            choice = new Scanner(System.in).nextLine();
        }
    }
}
