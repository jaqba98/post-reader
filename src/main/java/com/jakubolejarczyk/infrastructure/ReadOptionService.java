package com.jakubolejarczyk.infrastructure;

import java.util.Scanner;

public class ReadOptionService {
    private final Scanner scanner;

    public ReadOptionService() {
        scanner = new Scanner(System.in);
    }

    public String readOption() {
        try {
            String input = scanner.nextLine();
            int option = Integer.parseInt(input);
            return switch (option) {
                case 0 -> "exit";
                case 1 -> "posts";
                default -> "error";
            };
        } catch (Exception e) {
            return "error";
        }
    }
}
