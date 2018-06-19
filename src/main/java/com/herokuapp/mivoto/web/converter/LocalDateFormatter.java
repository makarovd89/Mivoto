package com.herokuapp.mivoto.web.converter;

import org.springframework.format.Formatter;
import org.springframework.util.StringUtils;
import java.time.LocalDate;
import java.util.Locale;

import static java.time.format.DateTimeFormatter.ISO_LOCAL_DATE;

public class LocalDateFormatter implements Formatter<LocalDate> {

    @Override
    public LocalDate parse(String text, Locale locale) {
        return parseLocalDate(text);
    }

    private static LocalDate parseLocalDate(String str) {
        return StringUtils.isEmpty(str) ? null : LocalDate.parse(str);
    }

    @Override
    public String print(LocalDate lt, Locale locale) {
        return lt.format(ISO_LOCAL_DATE);
    }
}