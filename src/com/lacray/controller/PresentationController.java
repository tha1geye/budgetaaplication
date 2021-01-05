package com.lacray.controller;

import com.lacray.controller.events.AppEvent;
import com.lacray.controller.events.BudgetEvent;
import com.lacray.model.Budget;

import java.util.ArrayList;

public interface PresentationController {
    public void triggerAddBudgetAction();
    public void registerEventCoordinator(EventCoordinator eventCoordinator);
    public void handleEvent(AppEvent event);
    public void updateBudgets(ArrayList<Budget> budgets);
}
