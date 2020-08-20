package com.gamejava.adapter.actions;

import com.gamejava.dao.impl.AnswerDAO;
import com.gamejava.dao.impl.QuestionDAO;
import com.gamejava.dao.impl.ScoreDAO;
import com.gamejava.dao.impl.UserDAO;
import com.gamejava.model.Answer;
import com.gamejava.model.Question;
import com.gamejava.services.impl.AnswerService;
import com.gamejava.services.impl.QuestionService;
import com.gamejava.services.impl.ScoreService;
import com.gamejava.services.impl.UserService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Action {
    private QuestionService questionService;
    private AnswerService answerService;
    private ScoreService scoreService;
    private UserService userService;

    private Map<Question, List<Answer>> questionAnswerMap;
    private List<Answer> answerList;
    private List<Question> questionList;

    public Action() {
        this.questionService = new QuestionService(new QuestionDAO());
        this.answerService = new AnswerService(new AnswerDAO());
        this.scoreService = new ScoreService(new ScoreDAO());
        this.userService = new UserService(new UserDAO());
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

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public ScoreService getScoreService() {
        return scoreService;
    }

    public void setScoreService(ScoreService scoreService) {
        this.scoreService = scoreService;
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
