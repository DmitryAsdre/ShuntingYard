package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        try{
            TokenGenerator token_generator = new TokenGenerator("1 + 2.5 : 4? ");
            Token tmp = token_generator.getNext();
            while(tmp.getToken() != Tokens.END){
                System.out.println(tmp.toString());
                tmp = token_generator.getNext();
            }
        }catch(RuntimeException e){
            System.out.println(e.getMessage());
        }
    }
}
