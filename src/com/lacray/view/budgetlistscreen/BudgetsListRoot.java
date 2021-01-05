package com.lacray.view.budgetlistscreen;

import com.lacray.controller.PresentationController;
import com.lacray.model.Budget;
import com.lacray.view.HeaderBox;
import javafx.collections.ObservableList;
import javafx.scene.layout.BorderPane;

public class BudgetsListRoot extends BorderPane {
    private PresentationController presentationController;

    private HeaderBox headerBox;
    private BudgetListVBox budgetListVBox;
    private BudgetButtonBar buttonBar;
    private BudgetListInfoBox infoBox;

    private Budget selectedBudget;

    public BudgetsListRoot(PresentationController presentationController) {
        super();
        this.presentationController = presentationController;
        selectedBudget = null;
        createComponents();
        createChildren();
        setLayout();
        presentationController.requestUpdate();
    }

    private void createComponents(){
    }

    private void createChildren(){
        this.headerBox = new HeaderBox();
        this.budgetListVBox = new BudgetListVBox(this);
        createButtonBar();
        createInfoBox();
    }

    private void createButtonBar(){
        this.buttonBar = new BudgetButtonBar(presentationController);
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


    public void setSelectedBudgetByIndex(int index){
        System.out.println("reimplement setSelectedBudgetByIndex");
    }

    private void setSelectedBudget(Budget budget){
        selectedBudget = budget;
        update();
    }

    private void update(){
        infoBox.update(selectedBudget);
    }

    public void updateBudgets(ObservableList<String> budgetsListTitles){
        budgetListVBox.updateBudgets(budgetsListTitles);
    }
}
