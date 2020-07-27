package com.twu.user;

import com.twu.hotSearch.Operator;
import com.twu.utils.Operation;
import com.twu.utils.Tips;

import java.util.Scanner;

public class Manager implements PersonInterface {
    private final String name;
    private final Scanner scanner = new Scanner(System.in);

    public Manager(String name) {
        this.name = name;
    }

    public void operatePermission() {
        System.out.println("你好!, " + this.name + ", 你可以" +
                "\n1、" + Operation.CHECK_RANK.getDescription() +
                "\n2、" + Operation.ADD_HOT_SEARCH.getDescription() +
                "\n3、" + Operation.ADD_SUPER_HOT_SEARCH.getDescription() +
                "\n4、" + "退出");
    }

    public void operate(int selected) {
        switch (selected) {
            case 1:
                show();
                break;
            case 2:
                add();
                break;
            case 3:
                addSuper();
                break;
            default:
                System.out.println("已退出");
                break;
        }
    }

    @Override
    public void show() {
        Operator.show();
        operatePermission();
        try {
            int input = scanner.nextInt();
            operate(input);
        } catch (Exception e) {
            System.out.println(Tips.WARNING_INPUT.getDescription());
            show();
        }
    }

    @Override
    public void add() {
        Operator.add();
        operatePermission();
        try {
            int input = scanner.nextInt();
            operate(input);
        } catch (Exception e) {
            System.out.println(Tips.WARNING_INPUT.getDescription());
            add();
        }
    }

    private void addSuper() {
        Operator.addSuper();
        operatePermission();
        try {
            int input = scanner.nextInt();
            operate(input);
        } catch (Exception e) {
            System.out.println(Tips.WARNING_INPUT.getDescription());
            addSuper();
        }
    }
}
