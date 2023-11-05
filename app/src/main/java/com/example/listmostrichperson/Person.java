package com.example.listmostrichperson;

public class Person {
    String name;
    int flag_res; // имя ресурса флага
    String money; // состояние в строковом формате

    public Person(String name, String money, int flag_res) {
        this.flag_res = flag_res;
        this.money = money;
        this.name = name;
    }
    public String getMoney(){
        return this.money;
    }
    public int getFlagResource() {
        return flag_res;
    }

    public String getName() {
        return name;
    }
}