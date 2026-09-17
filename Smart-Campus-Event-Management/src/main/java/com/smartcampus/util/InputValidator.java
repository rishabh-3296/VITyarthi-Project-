package com.smartcampus.util;
import java.time.LocalDate;
public final class InputValidator {
    private InputValidator(){}
    public static String required(String v,String field){if(v==null||v.isBlank())throw new IllegalArgumentException(field+" cannot be empty.");return v.trim();}
    public static int positiveInt(String v,String field){int n;try{n=Integer.parseInt(v);}catch(Exception e){throw new IllegalArgumentException(field+" must be a number.");}if(n<=0)throw new IllegalArgumentException(field+" must be positive.");return n;}
    public static LocalDate date(String v){try{return LocalDate.parse(v);}catch(Exception e){throw new IllegalArgumentException("Date must use YYYY-MM-DD.");}}
}
