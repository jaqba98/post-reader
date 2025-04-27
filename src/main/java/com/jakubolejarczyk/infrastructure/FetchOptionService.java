package com.jakubolejarczyk.infrastructure;

import com.jakubolejarczyk.enums.OptionEnum;
import lombok.AllArgsConstructor;
import lombok.val;

import java.util.Scanner;

@AllArgsConstructor
public class FetchOptionService {
    private final Scanner scanner;

    public OptionEnum fetch() {
        try {
            val input = scanner.nextLine();
            val option = Integer.parseInt(input);
            return switch (option) {
                case 0 -> OptionEnum.EXIT;
                case 1 -> OptionEnum.POSTS;
                default -> OptionEnum.ERROR;
            };
        } catch (Exception e) {
            return OptionEnum.ERROR;
        }
    }
}
