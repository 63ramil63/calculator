package org.example;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    ArrayList<Character> list = new ArrayList<>();

    ArrayList<String> numbers = new ArrayList<>();
    ArrayList<String> znaki = new ArrayList<>();
    public static void main(String[] args) {
        Main main = new Main();
        System.out.println("Введите выражение, в конце поставьте знак =\n" + "sqrt-корень\n cos,sin,tg,ctg\n число#система_счисления\n ");
        main.list.add('+');
        main.list.add('-');
        main.list.add('/');
        main.list.add('*');
        main.list.add('%');
        main.list.add('=');
        main.readString();
    }

    public void readString(){
        numbers.clear();
        znaki.clear();
        String number = "";
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();
        if(text.equals("exit")){
            System.exit(0);
        }
        for(int i = 0; i<text.length(); i++){
            char c = text.charAt(i);
            if(!list.contains(c)){
                number = number + c;

            }else{
                if(!number.isEmpty())
                {
                    numbers.add(number);
                    number = "";
                }
                znaki.add(String.valueOf(c));
            }
        }
        System.out.println(numbers);
        System.out.println(znaki);

        for(int i = 0; i<numbers.size(); i++){
            String s = numbers.get(i);
            String result ="";
            if(numbers.get(i).contains("^")){
                float res = 1;
                float num1 = 1;
                number = "";
                float num2;
                boolean firstnum = false;
                for(int g = 0; g < s.length(); ++g){
                    char c = s.charAt(g);
                    if(c != '^'){
                        number = number + c;
                    }else{
                        if(!firstnum) {
                            num1 = Float.parseFloat(number);
                            firstnum = true;
                        }
                        number = "";
                    }
                }
                num2 = Float.parseFloat(number);
                for(int x = 1; x <= num2; x++){
                    res = res * num1;
                }
                result = Float.toString(res);
                numbers.set(i,result);
            }else
            if(numbers.get(i).contains("sqrt")){
                String newNumber = s.replace("sqrt", "");
                double num = Double.parseDouble(newNumber);
                num = Math.sqrt(num);
                result = Double.toString(num);
                numbers.set(i, result);
            }else
            if(numbers.get(i).contains("sin")){
                String newNumber = s.replace("sin","");
                double num = Double.parseDouble(newNumber);
                num = Math.sin(Math.toRadians(num));
                result = Double.toString(num);
                numbers.set(i, result);
            }else
            if(numbers.get(i).contains("cos")){
                String newNumber = s.replace("cos","");
                double num = Double.parseDouble(newNumber);
                num = Math.cos(Math.toRadians(num));
                result = Double.toString(num);
                numbers.set(i, result);
            }else
            if(numbers.get(i).contains("ctg")){
                String newNumber = s.replace("ctg","");
                double num = Double.parseDouble(newNumber);
                num = Math.cos(Math.toRadians(num))/Math.sin(Math.toRadians(num));
                result = Double.toString(num);
                numbers.set(i, result);
                System.out.println("ctg");
            }else
            if(numbers.get(i).contains("tg")){
                String newNumber = s.replace("tg","");
                double num = Double.parseDouble(newNumber);
                num = Math.sin(Math.toRadians(num))/Math.cos(Math.toRadians(num));
                result = Double.toString(num);
                numbers.set(i, result);
                System.out.println("tg");
            }
            if(numbers.get(i).contains("!")){
                String newNumber = s.replace("!","");
                int num = Integer.parseInt(newNumber);
                int sum = 1;
                for(int g = num; g >1; g--){
                    sum = sum * g;
                }
                result = Float.toString(sum);
                numbers.set(i, result);
            }
            if(numbers.get(i).contains("#")){
                int num1 = 0;
                boolean firstNum = false;
                number="";
                int num2 = 0;
                for(int g = 0; g <s.length(); g++){
                    char c = text.charAt(g);
                    if(c != '#'){
                        number = number + c;
                    }else{
                        if(!firstNum){
                            firstNum = true;
                            num1 = Integer.parseInt(number);
                        }
                        number = "";
                    }
                }
                num2 = Integer.parseInt(number);
                switch (num2){
                    case 2:
                        System.out.println(Integer.toBinaryString(num1).toUpperCase());
                        readString();
                        break;
                    case 8:
                        System.out.println(Integer.toOctalString(num1).toUpperCase());
                        readString();
                        break;
                    case 16:
                        System.out.println(Integer.toHexString(num1).toUpperCase());
                        readString();
                        break;
                }

            }
        }
        Calc();
    }

    public void Calc(){
        float sum = Float.parseFloat(numbers.getFirst());
        for(int i =0; i<znaki.size(); ++i){
            switch (znaki.get(i)){
                case "+":
                    sum = sum + Float.parseFloat(numbers.get(i+1));
                    break;
                case "-":
                    sum = sum - Float.parseFloat(numbers.get(i+1));
                    break;
                case "/":
                    sum = sum / Float.parseFloat(numbers.get(i+1));
                    break;
                case "*":
                    sum = sum * Float.parseFloat(numbers.get(i+1));
                    break;
                case "%":
                    sum = sum % Float.parseFloat(numbers.get(i+1));
                    break;
            }
        }
        System.out.println(sum);
        readString();
    }
}
