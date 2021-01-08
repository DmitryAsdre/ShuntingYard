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

    public boolean isError(){return token == Tokens.ERROR;}
    public boolean isBegin(){return token == Tokens.BEGIN;}
    public boolean isEnd(){return token == Tokens.END;}
    public boolean isNum(){return token == Tokens.NUM;};
    public boolean isRBracket(){return token == Tokens.R_BRACKET;}
    public boolean isLBracket(){return token == Tokens.L_BRACKET;}
    public boolean isMinus(){return token == Tokens.MINUS;}
    public boolean isPlus(){return token == Tokens.PLUS;}
    public boolean isDiv(){return token == Tokens.DIV;}
    public boolean isMul(){return token == Tokens.MUL;}
    public boolean isOperator(){return isMul() || isDiv() || isPlus() || isMinus();}
    public boolean isBracket(){return isLBracket() || isRBracket();}

    public int getPriority(){
        if(!isOperator())
            throw new RuntimeException("cannot get priority for non operator");
        if(isDiv() || isMul())
            return 1;
        else
            return 0;
    }
    public String toString(){
        if(isError())
            return "ERROR";
        else if(isLBracket())
            return "L_BRACKET";
        else if(isRBracket())
            return "R_BRACKET";
        else if(isPlus())
            return "PLUS";
        else if(isMinus())
            return "MINUS";
        else if(isMul())
            return "MUL";
        else if(isDiv())
            return "DIV";
        else if(isNum())
            return "NUM:" + num;
        else if(isBegin())
            return "BEGIN";
        else if(isEnd())
            return "END";
        else
            throw new RuntimeException("cannot convert unknown token to string");
    }
}
