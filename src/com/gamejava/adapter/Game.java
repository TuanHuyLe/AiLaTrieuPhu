package com.gamejava.adapter;

import com.gamejava.model.Question;

import java.util.List;
import java.util.Scanner;

public class Game {
    private Integer score;
    private String answer;
    private Scanner scanner;
    private List<Question> questions;
    private QuestionAdapter questionAdapter;

    public Game() {
        this.scanner = new Scanner(System.in);
        this.questionAdapter = new QuestionAdapter();
        questionAdapter.read("src\\com\\gamejava\\questions\\questions.txt");
        this.questions = questionAdapter.getQuestionList();
    }

    public Game(List<Question> questionList) {
        this.scanner = new Scanner(System.in);
        this.questions = questionList;
    }

    public void run() {
        int i = 0;
        this.score = 0;
        do {
            System.out.println("\nCau hoi " + (i + 1) + ":\n" + this.questions.get(i).getQuestion());
            for (int j = 0; j < 4; j++) {
                System.out.println((j + 1) + ". " + this.questions.get(i).getAnswer().getAnswer().get(j));
            }
            System.out.println("Dap an cua ban la: ");
            this.answer = scanner.nextLine();
            if (this.answer.equals(this.questions.get(i).getCorrectAnswer())) {
                this.score += 1;
                System.out.println("Ban da tra loi dung. So diem: " + this.score);
                i += 1;
            } else {
                System.out.println("Ban da tra loi sai. So diem: " + this.score);
                System.out.println("Dap an dung la: " + this.questions.get(i).getCorrectAnswer());
                break;
            }
        } while (this.questions.size() != i);
        if (i == this.questions.size()) {
            System.out.println("Chuc mung ban da thang het cau hoi");
        }
    }
}
