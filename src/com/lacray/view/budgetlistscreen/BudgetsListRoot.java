package com.lacray.view.budgetlistscreen;

import com.lacray.controller.BudgetListController;
import com.lacray.controller.EventCoordinator;
import com.lacray.model.Budget;
import com.lacray.view.HeaderBox;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;

public class BudgetsListRoot extends BorderPane {
    private BudgetListController budgetListController;
    private EventCoordinator eventCoordinator;

    private HeaderBox headerBox;
    private BudgetListVBox budgetListVBox;
    private BudgetButtonBar buttonBar;
    private BudgetListInfoBox infoBox;

    private Budget selectedBudget;

    public BudgetsListRoot() {
        super();
        selectedBudget = null;
        createComponents();
        createChildren();
        setLayout();
    }

    private void createComponents(){
        this.budgetListController = null;
        this.eventCoordinator = null;
    }

    private void createChildren(){
        this.headerBox = new HeaderBox();
        this.budgetListVBox = new BudgetListVBox(this);
        createButtonBar();
        createInfoBox();
    }

    private void createButtonBar(){
        this.buttonBar = new BudgetButtonBar(eventCoordinator);
    }

    private void createInfoBox(){
        infoBox = new BudgetListInfoBox();
    }

    private void setLayout(){
        super.setTop(headerBox);
        super.setCenter(infoBox);
        super.setLeft(budgetListVBox);
        super.setBottom(buttonBar);

        // TODO: fix resize issue. move buttonbar somewhere that makes more sense.

    }

    public void registerBudgetController(BudgetListController controller){
        this.budgetListController = controller;
        this.budgetListVBox.registerBudgetListController(this.budgetListController);
    }

    public void registerEventCoordinator(EventCoordinator eventCoordinator){
        this.eventCoordinator = eventCoordinator;
    }

    public void setSelectedBudgetByIndex(int index){
        setSelectedBudget(budgetListController.getSelectedBudgetByIndex(index));
    }

    private void setSelectedBudget(Budget budget){
        selectedBudget = budget;
        update();
    }

    private void update(){
        infoBox.update(selectedBudget);

    }
}
