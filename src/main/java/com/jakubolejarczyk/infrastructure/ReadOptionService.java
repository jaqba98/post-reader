package com.jakubolejarczyk.infrastructure;

import java.util.Scanner;

public class ReadOptionService {
    private final Scanner scanner;

    public ReadOptionService() {
        scanner = new Scanner(System.in);
    }

    public int read() {
        try {
            String input = scanner.nextLine();
            int option = Integer.parseInt(input);
            return switch (option) {
                case 0 -> 0;
                case 1 -> 1;
                default -> -1;
            };
        } catch (Exception e) {
            return -1;
        }
    }
}
