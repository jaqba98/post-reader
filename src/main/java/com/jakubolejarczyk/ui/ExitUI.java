package com.jakubolejarczyk.ui;

import com.jakubolejarczyk.model.ui.UIModel;

public class ExitUI implements UIModel {
    public void draw() {
        System.out.println();
        System.out.println("--------------------------------------------------");
        System.out.println("The work is done. Goodbye!");
        System.out.println("--------------------------------------------------");
        System.out.println();
    }
}
