package com.example.springex.controller.formmater;

import org.springframework.format.Formatter;

import java.text.ParseException;
import java.util.Locale;

public class CheckboxFormatter implements Formatter<Boolean> {

    @Override
    public Boolean parse(String text, Locale locale) throws ParseException {
        if (text!=null && text.equals("on")) {
            return true;
        }
        return false;
    }

    @Override
    public String print(Boolean object, Locale locale) {
        return object.toString();
    }
}
