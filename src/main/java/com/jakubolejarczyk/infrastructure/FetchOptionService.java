package com.jakubolejarczyk.infrastructure;

import com.jakubolejarczyk.enums.OptionEnum;
import lombok.val;
import org.springframework.stereotype.Service;

import java.util.Scanner;

@Service
public class FetchOptionService {
    private final Scanner scanner;

    public FetchOptionService() {
        this.scanner = new Scanner(System.in);
    }

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
