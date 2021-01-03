package com.lacray.model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Budget {
    private int id;
    private String title;
    private LocalDate date;
    private int month;
    private int year;
    private ArrayList<Item> items;

    public Budget(String title, LocalDate date){
        this.title = title;
        this.date = date;
        this.year = date.getYear();
        this.month = date.getMonthValue();
        items = new ArrayList<>();
    }

    public void setTitle(String title){
        this.title = title;
    }

    public String getTitle(){
        return this.title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public boolean containsItem(Item item){
        return this.items.contains(item);
    }

    public void addItem(Item item){
        if(!containsItem(item)){
            this.items.add(item);
        }
    }
}
