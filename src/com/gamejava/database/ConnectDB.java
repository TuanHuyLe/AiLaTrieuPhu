package com.gamejava.database;

import com.gamejava.model.Answer;
import com.gamejava.model.Question;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ConnectDB {
    private String url = "jdbc:mysql://localhost:3306/ailatrieuphu?characterEncoding=latin1&useConfigs=maxPerformance";
    private String user = "root";
    private String password = "tuan123";
    private String driver = "com.mysql.jdbc.Driver";

    private Connection conn;
    private Statement stmt;
    private ResultSet rs;
    private PreparedStatement prStmt;

    private Question question;
    private Answer answer;
    private List<Question> questionList;

    public ConnectDB() {
        questionList = new ArrayList<>();
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void getAll() {
        try {
            conn = DriverManager.getConnection(url, user, password);
            stmt = conn.createStatement();
            String sql = "SELECT question, correct_answer, answer FROM questions INNER JOIN answers ON questions.id=question_id;";
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                String question = rs.getString("question");
                this.answer = new Answer();
                this.answer.addAnswer(rs.getString("answer"));
                rs.next();
                this.answer.addAnswer(rs.getString("answer"));
                rs.next();
                this.answer.addAnswer(rs.getString("answer"));
                rs.next();
                this.answer.addAnswer(rs.getString("answer"));
                String correctAnswer = rs.getString("correct_answer");
                this.question = new Question(question, answer, correctAnswer);
                this.questionList.add(this.question);
            }
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Question> getQuestionList() {
        return questionList;
    }

    private int add(String table, String val1, String val2) {
        try {
            conn = DriverManager.getConnection(url, user, password);
            prStmt = conn.prepareStatement("insert into " + table + " values(?,?,?)");
            prStmt.setInt(1, 0);
            prStmt.setString(2, val1);
            prStmt.setString(3, val2);
            int affectedRows = prStmt.executeUpdate();
            if (affectedRows != 0) {
                rs = prStmt.getGeneratedKeys();
                if (rs.next()) {
                    return rs.getInt(1);
                }
            }
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int addQuestion(String question, String correct_answer) {
        return add("questions", question, correct_answer);
    }

    public int addAnswer(String answer, Integer question_id) {
        return add("answers", answer, question_id.toString());
    }
}
