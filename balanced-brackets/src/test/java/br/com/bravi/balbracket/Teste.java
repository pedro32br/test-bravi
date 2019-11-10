package br.com.bravi.balbracket;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

public class Teste {

    public static void main(String[] args) {

        String input = "{ cs dv } (([[{s c d c sd}]])) [[ 1 2 / x z ;zcsaw][]´´583&!@#$%¨&*(){}+".replaceAll("[^(){}\\[\\]]","");
        Boolean x = validBrackets(input);

    }

    public static Boolean validBrackets(String input){
        HashMap<Character, Character> token = new HashMap<>();
        token.put('(', ')');
        token.put('[', ']');
        token.put('{', '}');

        //ArrayList<Character> comparativeList = new ArrayList<>();
        Stack<Character> comparativeList = new Stack<>();

        for (int i = 0; i < input.length(); i++) {

            if(token.containsKey(input.charAt(i)))
                comparativeList.push(input.charAt(i));
            else if(token.containsValue(input.charAt(i))){

                if(comparativeList.empty())
                    return false;
                char last = comparativeList.pop();
                if(token.get(last).equals(input.charAt(i)))
                    continue;
                else
                    return false;
            }
        }
        return comparativeList.empty();
    }

}
