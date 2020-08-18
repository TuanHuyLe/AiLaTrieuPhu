package com.gamejava.adapter;

import com.gamejava.model.Answer;
import com.gamejava.model.Question;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class QuestionAdapter {
    private File file;
    private Scanner myReader;
    private Question question;
    private Answer answer;
    private List<Question> questionList;

    public QuestionAdapter() {
        this.questionList = new ArrayList<>();
    }

    public void read(String fileName) {
        try {
            this.file = new File(fileName);
            this.myReader = new Scanner(file);
            while (myReader.hasNextLine()) {
                String question = myReader.nextLine();
                this.answer = new Answer();
                this.answer.addAnswer(myReader.nextLine());
                this.answer.addAnswer(myReader.nextLine());
                this.answer.addAnswer(myReader.nextLine());
                this.answer.addAnswer(myReader.nextLine());
                String correctAnswer = myReader.nextLine();
                this.question = new Question(question, answer, correctAnswer);
                this.questionList.add(this.question);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred. File not found!");
            e.printStackTrace();
        }
    }

    public List<Question> getQuestionList() {
        return questionList;
    }

}
