package com.jakubolejarczyk;

import com.jakubolejarczyk.application.Application;
import com.jakubolejarczyk.infrastructure.FetchOptionService;
import com.jakubolejarczyk.ui.ExitUI;
import com.jakubolejarczyk.ui.HrUI;
import com.jakubolejarczyk.ui.MenuUI;
import com.jakubolejarczyk.ui.WrongOptionUI;
import lombok.val;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        val scanner = new Scanner(System.in);
        val menuUI = new MenuUI();
        val fetchOptionService = new FetchOptionService(scanner);
        val hrUI = new HrUI();
        val exitUI = new ExitUI();
        val wrongOptionUI = new WrongOptionUI();
        val application = new Application(menuUI, fetchOptionService, hrUI, exitUI, wrongOptionUI);
        application.start();
    }
}
