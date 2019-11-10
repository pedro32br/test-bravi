package br.com.bravi.balbracket.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Stack;

@Controller
@RequestMapping("/")
public class BracketController {

    /**
     * Check sequence to check if this brackets close
     *
     * @param input of string.
     * @return True or False.
     * */
    @PostMapping("/full")
    public Boolean isBalancedFull(String input){
        input = input.replaceAll("[^(){}\\[\\]]","");

        while(input.contains("(") || input.contains(")")){

            if(input.contains("(") && input.contains(")")){
                if(input.indexOf("(") < input.indexOf(")")) {
                    input = input.replaceFirst("\\(", "");
                    input = input.replaceFirst("\\)", "");
                }
                else
                    return false;
            }
            else
                return false;
        }
        while(input.contains("[") || input.contains("]")){

            if(input.contains("[") && input.contains("]")){
                if(input.indexOf("[") < input.indexOf("]")) {
                    input = input.replaceFirst("\\[", "");
                    input = input.replaceFirst("]", "");
                }
                else
                    return false;
            }
            else
                return false;
        }
        while(input.contains("{") || input.contains("}")){

            if(input.contains("{") && input.contains("}")){
                if(input.indexOf("{") < input.indexOf("}")) {
                    input = input.replaceFirst("\\{", "");
                    input = input.replaceFirst("}", "");
                }
                else
                    return false;
            }
            else
                return false;
        }

        return true;
    }

    @GetMapping()
    public String showHomePage(ModelMap model){
        return "homePage";
    }

    @PostMapping()
    public String isBalanced(ModelMap model, @RequestParam String input) {

        input = input.replaceAll("[^(){}\\[\\]]","");
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

                if(comparativeList.empty()){
                    model.put("errorMessage", "Brackets aren't balanced");
                    return "homePage";
                }
                char last = comparativeList.pop();
                if(token.get(last).equals(input.charAt(i)))
                    continue;
                else{
                    model.put("errorMessage", "Brackets aren't balanced");
                    return "homePage";
                }
            }
        }
        if(comparativeList.empty()){
            model.put("success", "Brackets are balanced");
            return "homePage";
        } else {
            model.put("errorMessage", "Brackets aren't balanced");
            return "homePage";
        }
    }
}
