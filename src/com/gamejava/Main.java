package com.gamejava;

import com.gamejava.dao.impl.QuestionDAO;
import com.gamejava.model.Question;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        QuestionDAO questionDAO = new QuestionDAO();
//        List<Question> questionList = questionDAO.findAll();
//        for (Question question : questionList) {
//            System.out.println(question.getId() + ", " + question.getQuestion() + ", " + question.getCorrectAnswer());
//        }
        Question question = questionDAO.findOne(1);
        System.out.println(question.getId() + ", " + question.getQuestion() + ", " + question.getCorrectAnswer());
    }
}
