package com.company;

public class Token {
    private double num=0.0;
    private Tokens token;


    public Token(Tokens t){
        token = t;
    }
    public Token(){
        num=0.0;
        token = Tokens.ERROR;
    }
    public Token(Tokens t, double n){
        token = t;
        num = n;
    }
    public Token(Token t){
        num = t.num;
        token = t.token;
    }

    public void setToken(Tokens t){
        token = t;
    }
    public void setNum(double n){
        num = n;
    }

    public Tokens getToken(){
        return token;
    }
    public double getNum(){
        return num;
    }
    public String toString(){
        if(token == Tokens.ERROR)
            return "ERROR";
        else if(token == Tokens.L_BRACKET)
            return "L_BRACKET";
        else if(token == Tokens.R_BRACKET)
            return "R_BRACKET";
        else if(token == Tokens.PLUS)
            return "PLUS";
        else if(token == Tokens.MINUS)
            return "MINUS";
        else if(token == Tokens.MUL)
            return "MUL";
        else if(token == Tokens.DIV)
            return "DIV";
        else if(token == Tokens.NUM)
            return "NUM:" + num;
        else
            return "END";
    }
}
