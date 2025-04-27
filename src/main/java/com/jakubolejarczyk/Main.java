package com.jakubolejarczyk;

import com.jakubolejarczyk.application.Application;
import com.jakubolejarczyk.infrastructure.FetchOptionService;
import com.jakubolejarczyk.ui.HrUI;
import com.jakubolejarczyk.ui.MenuUI;
import lombok.val;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        val scanner = new Scanner(System.in);
        val menuUI = new MenuUI();
        val fetchOptionService = new FetchOptionService(scanner);
        val hrUI = new HrUI();
        val application = new Application(menuUI, fetchOptionService, hrUI);
        application.start();
    }
}
