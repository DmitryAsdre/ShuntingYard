package com.company;

import javax.management.relation.RelationNotFoundException;
import java.util.Vector;
import java.util.Stack;

public class Calculator {
    private static Vector<Token> getPostfixNotation(String s){
        return ShuntingYard.getPostfixNotation(s);
    }
    public static double calculateExpr(String s){
        if(s.length() == 0)
            throw new RuntimeException("unexpected input");
        Vector<Token> postfix_notation = getPostfixNotation(s);
        Stack<Double> stack = new Stack<Double>();
        for(Token token : postfix_notation){
            if(token.isNum())
                stack.push(token.getNum());
            else if(token.isOperator()){
                Double cur = stack.pop();
                Double prev = stack.pop();
                Double res = new Double(0.0);
                if(token.isMul())
                    res = cur * prev;
                else if(token.isDiv()){
                    if(cur == 0.0)
                        throw new RuntimeException("division by zero");
                    res = prev / cur;
                }
                else if(token.isPlus())
                    res = prev + cur;
                else if(token.isMinus())
                    res = prev- cur;
                stack.push(res);
            }else
                throw new RuntimeException("unknown token");
        }
        assert stack.size() == 1 : "stack size is not 1";
        return stack.pop();
    }
}
