package com.gamejava.adapter.actions;

import com.gamejava.model.Answer;
import com.gamejava.model.Question;
import com.gamejava.services.impl.AnswerService;
import com.gamejava.services.impl.QuestionService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Action {
    private QuestionService questionService;
    private AnswerService answerService;

    private Map<Question, List<Answer>> questionAnswerMap;
    private List<Answer> answerList;
    private List<Question> questionList;

    public Action(QuestionService questionService, AnswerService answerService) {
        this.questionService = questionService;
        this.answerService = answerService;
        initQuestions();
    }

    private void initQuestions() {
        questionAnswerMap = new HashMap<>();
        answerList = answerService.findAll();
        questionList = questionService.findAll();
        for (Question question : questionList) {
            List<Answer> answers = new ArrayList<>();
            for (Answer answer : answerList) {
                if (answer.getQuestionId() == question.getId()) {
                    answers.add(answer);
                }
            }
            questionAnswerMap.put(question, answers);
        }
    }

    public Map<Question, List<Answer>> getQuestionAnswerMap() {
        return questionAnswerMap;
    }

    public void setQuestionAnswerMap(Map<Question, List<Answer>> questionAnswerMap) {
        this.questionAnswerMap = questionAnswerMap;
    }

    public List<Answer> getAnswerList() {
        return answerList;
    }

    public void setAnswerList(List<Answer> answerList) {
        this.answerList = answerList;
    }

    public List<Question> getQuestionList() {
        return questionList;
    }

    public void setQuestionList(List<Question> questionList) {
        this.questionList = questionList;
    }
}
