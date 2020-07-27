package com.twu;

import com.twu.user.Manager;
import com.twu.user.PersonInterface;
import com.twu.user.User;
import com.twu.utils.Tips;
import com.twu.utils.UserType;

import java.util.Scanner;

public class Main {

    private static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println(Tips.ASK_USER_TYPE.getDescription()
                + "\n1、" + UserType.MANAGER.getName()
                + "\n2、" + UserType.USER.getName());

        int userTypeSelected;
        try {
            userTypeSelected = SCANNER.nextInt();
        } catch (Exception e) {
            throw new RuntimeException(Tips.WARNING_INPUT.getDescription());
        }
        System.out.println(Tips.ASK_USER_NAME.getDescription());
        String userName = SCANNER.next().trim();
        switch (userTypeSelected) {
            case 1:
                operation(new Manager(userName));
                break;
            case 2:
                operation(new User(userName));
                break;
            default:
                System.out.println(Tips.QUIT.getDescription());
                break;
        }
        main(null);
    }

    private static void operation(PersonInterface person) {
        person.operatePermission();
        try {
            int selected = SCANNER.nextInt();
            person.operate(selected);
        } catch (Exception e) {
            System.out.println(Tips.WARNING_INPUT.getDescription());
            operation(person);
        }
    }

}
