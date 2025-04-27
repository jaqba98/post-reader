package com.jakubolejarczyk.ui;

import com.jakubolejarczyk.model.ui.UIModel;

public class MenuUI implements UIModel {
    public void draw() {
        System.out.println("########################################");
        System.out.println("# POST READER v0.1 by Jakub Olejarczyk #");
        System.out.println("########################################");
        System.out.println("1) Posts");
        System.out.println("0) Exit program");
        System.out.print("Select API to load: ");
    }
}
