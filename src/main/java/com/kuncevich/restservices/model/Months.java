package com.kuncevich.restservices.model;

import java.util.stream.Collectors;

public enum Months {
    январь,
    февраль,
    март,
    апрель,
    май,
    июнь,
    июль,
    август,
    сентябрь,
    октябрь,
    ноябрь,
    декабрь;

    /**
     * Method formats string by example:
     * январь -> Я-Н-В-А-Р-Ь
     */
    public String getFormatedString() {
        String str = this.toString().toUpperCase().chars().mapToObj(
                c -> (char) c + "-"
        ).collect(Collectors.joining());
        return str.substring(0, str.length() - 1);
    }

    public static Months getMonthFromNumber(int number) {
        switch (number) {
            case 1:
                return Months.январь;
            case 2:
                return Months.февраль;
            case 3:
                return Months.март;
            case 4:
                return Months.апрель;
            case 5:
                return Months.май;
            case 6:
                return Months.июнь;
            case 7:
                return Months.июль;
            case 8:
                return Months.август;
            case 9:
                return Months.сентябрь;
            case 10:
                return Months.октябрь;
            case 11:
                return Months.ноябрь;
            case 12:
                return Months.декабрь;
        }
        return null;
    }

    // check that number from 1 to 12
    public static boolean isRightNumericMonth(Object num) {
        int i;
        try {
            i = Integer.parseInt(num.toString());
        } catch (NumberFormatException | NullPointerException ex) {
            return false;
        }
        return i <= 12 && i >= 1;
    }
}
