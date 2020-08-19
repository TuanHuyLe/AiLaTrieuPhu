package com.gamejava.adapter.actions;

import java.util.Scanner;

public class Game {
    private Account account;

    public Game() {
        account = new Account();
    }

    private void showHome() {
        System.out.println("==================== AI LÀ TRIỆU PHÚ ====================");
        System.out.println("1. Đăng nhập");
        System.out.println("2. Đăng ký");
        System.out.println("3. Thoát");
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
                if (account.checkLogin(name, password)) {
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

    private void showPlay(){

    }

    public void run() {
        int choice = 0;
        clearScreen();
        while (choice != 3) {
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
                        showPlay();
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
                default:
                    choice = 3;
            }
        }
    }
}
