package com.company.ui.enums;

public enum Browser {

    CHROME("Chrome"),
    FF("FireFox");

    private String name;

    @Override
    public  String toString(){
    return name;
}

    Browser(final String name)
    {
        this.name = name;
    }
}
