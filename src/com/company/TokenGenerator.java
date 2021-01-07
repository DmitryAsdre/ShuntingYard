package com.company;

public class TokenGenerator {
    private String data;
    private int cur_pos = 0;

    public TokenGenerator(String s){
        data = s.replaceAll("\\s+", "");
    }

    public void setString(String s){
        data = s.replaceAll("\\s+","");
        cur_pos = 0;
    }
    public void setZero(){
        cur_pos = 0;
    }

    public double getCurPos(){
        return cur_pos;
    }
    public String getString(){
        return data;
    }

    public Token getNext(){
        Token res = new Token();
        if(cur_pos >= data.length()) {
            res.setToken(Tokens.END);
            return res;
        }

        char cur_char = data.charAt(cur_pos);
        if(cur_char == '+'){
            res.setToken(Tokens.PLUS);
            cur_pos += 1;
        }
        else if(cur_char == '-'){
            res.setToken(Tokens.MINUS);
            cur_pos += 1;
        }
        else if(cur_char == '*') {
            res.setToken(Tokens.MUL);
            cur_pos += 1;
        }
        else if(cur_char == ':') {
            res.setToken(Tokens.DIV);
            cur_pos += 1;
        }
        else if(cur_char == '('){
            res.setToken(Tokens.L_BRACKET);
            cur_pos += 1;
        }
        else if(cur_char == '(') {
            res.setToken(Tokens.R_BRACKET);
            cur_pos += 1;
        }
        else if(Character.isDigit(cur_char)){
            int end_pos = cur_pos;
            while((end_pos < data.length())&&(Character.isDigit(data.charAt(end_pos)) || data.charAt(end_pos) == '.'))
                end_pos += 1;
            double d = Double.parseDouble(data.substring(cur_pos, end_pos));
            res.setToken(Tokens.NUM);
            res.setNum(d);
            cur_pos = end_pos;
        }
        else{
            throw new RuntimeException("Unexpected symbol in input!");
        }
        return res;
    }
}
