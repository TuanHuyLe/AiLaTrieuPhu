package com.gamejava;

import com.gamejava.adapter.Game;
import com.gamejava.database.ConnectDB;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ConnectDB myDB = new ConnectDB();
//        int questionId = myDB.addQuestion("que quan", "1");
//        myDB.addAnswer("nam dinh", questionId);
        myDB.getAll();
        Game game = new Game(myDB.getQuestionList());
        String choice = "Y";
        while (choice.equals("Y")) {
            game.run();
            System.out.println("Ban muon choi lai (Y/N): ");
            choice = new Scanner(System.in).nextLine();
        }
    }
}
