package com.company;

public class Main {

    private static String wrapperCalculator(String s){
        String output;
        try{
            Double tmp = Calculator.calculateExpr(s);
            return tmp.toString();
        }catch (RuntimeException e){
            return e.getMessage();
        }
    }

    public static void test_consistent(){
        assert  wrapperCalculator("1 + 1 - 3 + 4 * 5").equals("19.0") : "Test 1 failed";
        System.out.println("Test 1 : OK");
        assert wrapperCalculator("1 - 0 + 10 + 4").equals("15.0") : "Test 2 failed";
        System.out.println("Test 2 : OK");
        assert wrapperCalculator("(2 + 3 - 1)").equals("4.0") : "Test 3 failed";
        System.out.println("Test 3 : OK");
        assert  wrapperCalculator("((2*3 - 1))").equals("5.0") : "Test 4 failed";
        System.out.println("Test 4 : OK");
        assert  wrapperCalculator("(((2)))").equals("2.0"): "Test 5 failed";
        System.out.println("Test 5 : OK");
        assert  wrapperCalculator("(2:2)").equals("1.0") : "Test 6 failed";
        System.out.println("Test 6 : OK");
        assert wrapperCalculator("(1 + 3) : 4 - 1.0").equals("0.0"): "Test 7 failed";
        System.out.println("Test 7 : OK");
        assert  wrapperCalculator("3*(3 + 4 - (1 + 4))").equals("6.0"): "Test 8 failed";
        System.out.println("Test 8 : OK");
        assert wrapperCalculator("5 + (4 - 3) * 5 - 6*(19*(4 + 1) + 4)").equals("-584.0") : "Test 9 failed";
        System.out.println("Test 9 : OK");
        assert wrapperCalculator("5 + ((((4 - 3)))) * 5 - 6*(19*(4 + ((1))) + (4))").equals("-584.0"): "Test 10 failed";
        System.out.println("Test 10 : OK");
        assert wrapperCalculator("10 + 40 : 4").equals("20.0") : "Test 11 failed";
        System.out.println("Test 11 : OK");
    }
    public static void test_inconsistent(){
        assert wrapperCalculator("1 : 0").equals("division by zero") : "Test 12 failed";
        System.out.println("Test 12 : OK");
        assert wrapperCalculator("(1 + 34?)").equals("unexpected symbol in input"): "Test 13 failed";
        System.out.println("Test 13 : OK");
        assert wrapperCalculator("1 + (10").equals("unexpected input"):"Test 14 failed";
        System.out.println("Test 14 : OK");
        assert wrapperCalculator("(1 + 1").equals("unexpected input") : "Test 15 failed";
        System.out.println("Test 15 : OK");
        assert wrapperCalculator("(1 + 2) * (1 + 3))").equals("unexpected input") : "Test 16 failed";
        System.out.println("Test 16 : OK");
        assert wrapperCalculator("").equals("unexpected input") : "Test 17 failed";
        System.out.println("Test 17 : OK");
        assert  wrapperCalculator("*").equals("unexpected input") : "Test 18 failed";
        System.out.println("Test 18 : OK");
        assert  wrapperCalculator("3**10").equals("unexpected input") : "Test 19 failed";
        System.out.println("Test 19 : OK");
        assert  wrapperCalculator("(10 + 10) : (10 - 10)").equals("division by zero") : "Test 20 failed";
        System.out.println("Test 20 : OK");
    }
    public static void main(String[] args) {
        test_consistent();
        test_inconsistent();
        /*
        String s = args[0];
        System.out.println(wrapperCalculator(s));
         */
    }
}
