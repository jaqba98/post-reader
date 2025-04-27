package com.jakubolejarczyk.ui;

import com.jakubolejarczyk.model.ui.UIModel;

public class WrongOptionUI implements UIModel {
    public void draw() {
        System.out.println();
        System.out.println("--------------------------------------------------");
        System.out.println("ERROR: You entered an incorrect option. Try again!");
        System.out.println("--------------------------------------------------");
        System.out.println();
    }
}
