package com.lacray.controller;

import com.lacray.model.Budget;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;

public class BudgetListController {
    private ArrayList<Budget> budgets;
    private ArrayList<String> budgetTitles;
    private Budget selectedBudget;

    public BudgetListController(){
        this.budgets = new ArrayList<>();
        this.budgetTitles = new ArrayList<>();
        selectedBudget = null;
    }

    public boolean containsBudget(Budget budget){
        return this.budgets.contains(budget);
    }

    public void addBudget(Budget budget){
        if(!containsBudget(budget)){
            this.budgets.add(budget);
            this.budgetTitles.add(budget.getTitle());
        }
    }

    public ObservableList<String> getBudgetsObservableList(){
        return FXCollections.observableList(budgetTitles);
    }

    public Budget getBudgetByIndex(int index){
        return budgets.get(index);
    }

    public void setSelectedBudget(Budget budget){
        this.selectedBudget = budget;
        System.out.println("Selected Budget: " + selectedBudget.getTitle());
    }

    public Budget getSelectedBudgetByIndex(int index){
        setSelectedBudget(getBudgetByIndex(index));
        return selectedBudget;
    }

    public Budget getSelectedBudget(){
        return this.selectedBudget;
    }
}
