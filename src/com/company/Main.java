package com.company;

public class Main {

    public static void main(String[] args) {
        String s = args[0];
        try {
            Double output = Calculator.calculateExpr(s);
            System.out.println(output);
        }catch (RuntimeException e){
            System.out.println(e.getMessage());
        }
    }
}
