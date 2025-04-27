package com.jakubolejarczyk.utils;

import org.springframework.stereotype.Service;

@Service
public class LogUtils {
    public final String ANSI_RED = "\u001B[31m";
    public final String ANSI_GREEN = "\u001B[32m";
    public final String ANSI_LIGHT_BLUE = "\u001B[94m";
    public final String ANSI_YELLOW = "\u001B[93m";
    public final String ANSI_RESET = "\u001B[0m";

    public void emptyLine() {
        System.out.println();
    }

    public void error(String message) {
        error(message, true);
    }

    public void error(String message, boolean println) {
        if (println) {
            System.out.println(ANSI_RED + message + ANSI_RESET);
        } else {
            System.out.print(ANSI_RED + message + ANSI_RESET);
        }
    }

    public void success(String message) {
        success(message, true);
    }

    public void success(String message, boolean println) {
        if (println) {
            System.out.println(ANSI_GREEN + message + ANSI_RESET);
        } else {
            System.out.print(ANSI_GREEN + message + ANSI_RESET);
        }
    }

    public void info(String message) {
        info(message, true);
    }

    public void info(String message, boolean println) {
        if (println) {
            System.out.println(ANSI_LIGHT_BLUE + message + ANSI_RESET);
        } else {
            System.out.print(ANSI_LIGHT_BLUE + message + ANSI_RESET);
        }
    }

    public void task(String message) {
        task(message, true);
    }

    public void task(String message, boolean println) {
        if (println) {
            System.out.println(ANSI_YELLOW + message + ANSI_RESET);
        } else {
            System.out.print(ANSI_YELLOW + message + ANSI_RESET);
        }
    }
}
