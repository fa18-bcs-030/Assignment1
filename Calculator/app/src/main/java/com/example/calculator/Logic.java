package com.example.calculator;

public class Logic {
    protected MainActivity mainActivity;
    public String process(int a,int b,int ope){
        if(ope==0){
            return "Select Operater. ";
        }
        int result=0,reminder=0;
        switch (ope){
            case 1:
                result=a+b;
                break;
            case 2:
                result=a-b;
                break;
            case 3:
                result=a*b;
                break;
            case 4:
                try{
                    result=a/b;
                    reminder=a%b;
                    return result+" R: "+reminder;
                }
                catch (Exception e){
                    return "Devided by zero not allowed. ";
                }
        }
        return result+" ";
    }
}
