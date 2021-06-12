package com.faramarz.spring.basic;

import java.security.SecureRandom;
import java.util.Calendar;
import java.util.Scanner;

public class Captcha {

    public static void main(String[] args) {
        String captcha1 = String.valueOf(new SecureRandom().nextInt(20));
        String captcha2 = captcha1.concat(String.valueOf(Calendar.getInstance().getTimeInMillis()));
        String finalCaptcha = (captcha2 + captcha1).substring(0, 5);

        System.out.println("Your captcha: " + finalCaptcha);
        System.out.println("Type Input...\n");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();

        if (input.equals(finalCaptcha))
            System.out.println("Captcha confirmed!");
        else
            System.out.println("Captcha not valid!");

    }

}
