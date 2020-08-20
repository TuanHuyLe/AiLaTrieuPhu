package com.gamejava.adapter.actions;

import com.gamejava.model.Answer;
import com.gamejava.model.Question;
import com.gamejava.model.Score;
import com.gamejava.model.User;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Game {
    private Account account;
    private Action action;
    private Integer score;
    private User user = null;

    public Game() {
        account = new Account();
        action = new Action();
    }

    private void showHome() {
        System.out.println("==================== AI LÀ TRIỆU PHÚ ====================");
        if (user != null) {
            System.out.println("                 ==> Xin chào " + user.getName() + " <==");
        } else {
            System.out.println("==================> Bạn chưa đăng nhập <=================");
        }
        System.out.println("1. Đăng nhập");
        System.out.println("2. Đăng ký");
        System.out.println("3. Chơi");
        System.out.println("4. Điểm cao");
        System.out.println("5. Thoát");
        System.out.println("Mời bạn lựa chọn:");
    }

    private boolean showLogin(Scanner scanner) {
        System.out.println("==================== AI LÀ TRIỆU PHÚ ====================");
        System.out.println("======================= Đăng nhập =======================");
        while (true) {
            System.out.println("Tên tài khoản:");
            String name = scanner.nextLine();
            System.out.println("Mật khẩu:");
            String password = scanner.nextLine();
            System.out.println("- Đăng nhập (Y)");
            System.out.println("- Thoát (Any key)");
            String choice = scanner.nextLine();
            if (choice.equals("Y")) {
                Integer userId = account.checkLogin(name, password);
                if (userId != 0) {
                    user = new User();
                    user.setId(userId);
                    user.setName(name);
                    user.setPassword(password);
                    return true;
                } else {
                    System.out.println("Tài khoản, mật khẩu không chính xác");
                }
            } else {
                break;
            }
        }
        return false;
    }

    private boolean showRegister(Scanner scanner) {
        System.out.println("==================== AI LÀ TRIỆU PHÚ ====================");
        System.out.println("======================== Đăng ký ========================");
        while (true) {
            System.out.println("Tên tài khoản:");
            String name = scanner.nextLine();
            System.out.println("Mật khẩu:");
            String password = scanner.nextLine();
            System.out.println("- Đăng ký (Y)");
            System.out.println("- Thoát (Any key)");
            String choice = scanner.nextLine();
            if (choice.equals("Y")) {
                if (account.registerAccount(name, password)) {
                    return true;
                } else {
                    System.out.println("Tài khoản đã tồn tại");
                }
            } else {
                break;
            }
        }
        return false;
    }

    public static void clearScreen() {
        int i = 0;
        do {
            System.out.println();
            i++;
        } while (i < 100);
    }

    private void showPlay(Scanner scanner) {
        score = 0;
        Map<Question, List<Answer>> questionAnswerMap = action.getQuestionAnswerMap();
        int j = 1;
        for (Map.Entry<Question, List<Answer>> entry : questionAnswerMap.entrySet()) {
            Question question = entry.getKey();
            List<Answer> answers = entry.getValue();
            System.out.println("\nCâu hỏi " + j + ": " + question.getQuestion());
            String correctAnswer = "";
            for (int i = 1; i <= answers.size(); i++) {
                System.out.println(i + ". " + answers.get(i - 1).getAnswer());
                if (Integer.parseInt(question.getCorrectAnswer()) == i) {
                    correctAnswer = answers.get(i - 1).getAnswer();
                }
            }
            System.out.println("Đáp án của bạn là gì?");
            String answer = scanner.nextLine();
            clearScreen();
            if (answer.equals(question.getCorrectAnswer())) {
                score += 1;
                System.out.println("Bạn đã trả lời đúng. Số điểm hiện tại: " + score);
            } else {
                System.out.println("Bạn đã trả lời sai. Đáp án là: " + correctAnswer);
                break;
            }
            j += 1;
        }
        if (score == 10) {
            System.out.println("Chúc mừng bạn đã trả lời đúng hết các câu hỏi!");
        }
        Score score = new Score();
        score.setScore(this.score);
        score.setUserId(user.getId());
        action.getScoreService().save(score);
    }

    public void run() {
        int choice = 0;
        clearScreen();
        while (choice != 5) {
            showHome();
            Scanner scanner = new Scanner(System.in);
            choice = scanner.nextInt();
            scanner.nextLine();
            clearScreen();
            switch (choice) {
                case 1:
                    boolean check = showLogin(scanner);
                    clearScreen();
                    if (check) {
                        System.out.println("Đăng nhập thành công!");
                    }
                    choice = 1;
                    break;
                case 2:
                    boolean check2 = showRegister(scanner);
                    clearScreen();
                    if (check2) {
                        System.out.println("Đăng ký thành công!");
                    }
                    choice = 2;
                    break;
                case 3:
                    clearScreen();
                    if (user == null) {
                        System.out.println("Bạn chưa đăng nhập");
                    } else {
                        showPlay(scanner);
                    }
                    break;
                case 4:
                    clearScreen();
                    showHighScore();
                    break;
                default:
                    choice = 5;
            }
        }
    }

    private void showHighScore() {
        List<Score> scoreList = action.getScoreService().findAll();
        if (user == null) {
            System.out.println("Bạn chưa đăng nhập");
        } else {
            int j = 1;
            System.out.println("Điểm cao:");
            for (Score score : scoreList) {
                if (score.getUserId() == user.getId()) {
                    System.out.println(j + ". " + score.getScore());
                }
            }
        }
    }
}
