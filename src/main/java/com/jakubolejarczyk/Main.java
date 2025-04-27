package com.jakubolejarczyk;

import com.jakubolejarczyk.application.Application;
import com.jakubolejarczyk.builder.PostsDomainBuilder;
import com.jakubolejarczyk.builder.PostsDtoBuilder;
import com.jakubolejarczyk.infrastructure.FetchApiService;
import com.jakubolejarczyk.infrastructure.FetchOptionService;
import com.jakubolejarczyk.logic.PostsLogic;
import com.jakubolejarczyk.ui.ExitUI;
import com.jakubolejarczyk.ui.MenuUI;
import com.jakubolejarczyk.ui.WrongOptionUI;
import com.jakubolejarczyk.utils.LogUtils;
import com.jakubolejarczyk.utils.UriUtils;
import lombok.val;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        val uriUtils = new UriUtils();
        val fetchApiService = new FetchApiService(uriUtils);
        val logUtils = new LogUtils();
        val scanner = new Scanner(System.in);
        val menuUI = new MenuUI(logUtils);
        val fetchOptionService = new FetchOptionService(scanner);
        val exitUI = new ExitUI(logUtils);
        val wrongOptionUI = new WrongOptionUI(logUtils);
        val domainDtoBuilder = new PostsDtoBuilder();
        val postsDomainBuilder = new PostsDomainBuilder();
        val postsLogic = new PostsLogic(fetchApiService, domainDtoBuilder, postsDomainBuilder);
        val application = new Application(menuUI, fetchOptionService, exitUI, wrongOptionUI, postsLogic);
        application.start();
    }
}
