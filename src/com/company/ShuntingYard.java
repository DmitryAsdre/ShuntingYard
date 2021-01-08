package com.company;

import java.util.Vector;
import java.util.Stack;

public class ShuntingYard {
    public static Vector<Token> getPostfixNotation(String s){
        Vector<Token> output = new Vector<Token>();
        TokenGenerator token_generator = new TokenGenerator(s);
        Stack<Token> stack = new Stack<Token>();
        Token prev_token = new Token(Tokens.BEGIN);
        Token cur_token;
        do{
            cur_token = token_generator.getNext();
            checkConsistency(prev_token, cur_token);
            if(cur_token.isNum())
                output.add(cur_token);
            else if(cur_token.isLBracket())
                stack.push(cur_token);
            else if(cur_token.isRBracket()){
                if(stack.isEmpty())
                    throw new RuntimeException("unexpected input");
                while(!stack.isEmpty()){
                    Token tmp = stack.pop();
                    if(tmp.isLBracket())
                        break;
                    else if(stack.isEmpty())
                        throw new RuntimeException("unexpected input");
                    else
                        output.add(tmp);
                }
            }
            else if(cur_token.isOperator()){
                if(stack.isEmpty()) {
                    stack.push(cur_token);
                }
                else{
                    while(!stack.isEmpty()){
                        Token tmp = stack.peek();
                        if(tmp.isOperator() && tmp.getPriority() >= cur_token.getPriority()) {
                            output.add(tmp);
                            stack.pop();
                        }else{
                            break;
                        }
                    }
                    stack.push(cur_token);
                }
            }
            prev_token = cur_token;
        }while(cur_token.getToken() != Tokens.END);
        while(!stack.isEmpty()){
            cur_token = stack.pop();
            if(cur_token.isBracket())
                throw new RuntimeException("unexpected input");
            output.add(cur_token);
        }
        return output;
    }
    private static void checkConsistency(Token prev_token, Token cur_token){
        if(cur_token.isOperator()){
            if(prev_token.isOperator() || prev_token.isLBracket() || prev_token.isBegin())
                throw new RuntimeException("unexpected input");
        }else if(cur_token.isNum()){
            if(prev_token.isNum() || prev_token.isRBracket())
                throw new RuntimeException("unexpected input");
        }else if(cur_token.isLBracket()){
            if(prev_token.isNum() || prev_token.isRBracket())
                throw new RuntimeException("unexpected input");
        }else if(cur_token.isRBracket()){
            if(prev_token.isOperator() || prev_token.isLBracket() || prev_token.isBegin())
                throw new RuntimeException("unexpected input");
        }else if(cur_token.isEnd()){
            if(prev_token.isOperator() || prev_token.isLBracket() || prev_token.isBegin())
                throw new RuntimeException("unexpected input");
        }
    }
}
