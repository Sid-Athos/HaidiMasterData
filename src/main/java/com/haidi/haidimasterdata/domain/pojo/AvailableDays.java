package com.haidi.haidimasterdata.domain.pojo;

public enum AvailableDays {
    MONDAY,
    TUESDAY,
    WEDNESDAY,
    THURSDAY,
    FRIDAY,
    SATURDAY,
    SUNDAY;


    public static boolean checkEnumValue(String value){
        return value.equalsIgnoreCase(MONDAY.toString()) || value.equalsIgnoreCase(TUESDAY.toString())
                || value.equalsIgnoreCase(TUESDAY.toString())
                || value.equalsIgnoreCase(THURSDAY.toString())
                || value.equalsIgnoreCase(FRIDAY.toString())
                || value.equalsIgnoreCase(SATURDAY.toString())
                || value.equalsIgnoreCase(TUESDAY.toString())
                || value.equalsIgnoreCase(SUNDAY.toString());
    }
}
