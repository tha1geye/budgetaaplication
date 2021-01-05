package com.lacray.controller;

import com.lacray.model.Budget;

import java.time.LocalDate;
import java.util.ArrayList;

public class DataManager {
    private BudgetListController budgetListController;
    private EventCoordinator eventCoordinator;

    public DataManager(){
        budgetListController = new BudgetListController();
        eventCoordinator = null;
    }

    public void registerEventCoordinator(EventCoordinator eventCoordinator){
        this.eventCoordinator = eventCoordinator;
    }

    public void injectData(){
        budgetListController.addBudget(new Budget("July 2020", LocalDate.of(2020, 7, 1)));
        budgetListController.addBudget(new Budget("June 2020", LocalDate.of(2020, 6, 1)));
    }

    public void addBudget(Budget budget){

    }

    public ArrayList<Budget> getAllBudgets(){
        return budgetListController.getAllBudgets();
    }
}
