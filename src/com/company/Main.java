package com.company;
import java.util.Vector;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Vector<Token> output = ShuntingYard.getPostfixNotation("1 + (3*3 - 4):2");
        for(Token i : output){
            System.out.println(i.toString());
        }
        //Stack<Token> stack = new Stack<Token>();
        //stack.push(new Token(Tokens.BEGIN));
        //stack.push(new Token(Tokens.END));
        //System.out.println(stack.toString());
    }
}
