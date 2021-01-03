package com.lacray.view.budgetlistscreen;

import com.lacray.controller.BudgetListController;
import com.lacray.model.Budget;
import com.lacray.view.HeaderBox;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.layout.BorderPane;

public class BudgetsListRoot extends BorderPane {
    private BudgetListController budgetListController;
    private HeaderBox headerBox;
    private BudgetListVBox budgetListVBox;
    private ButtonBar buttonBar;
    private Button addButton;
    private Button deleteButton;
    private Button confirmButton;
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
    }

    private void createChildren(){
        this.headerBox = new HeaderBox();
        this.budgetListVBox = new BudgetListVBox(this);
        createButtonBar();
        createInfoBox();
    }

    private void createButtonBar(){
        this.buttonBar = new ButtonBar();
        createButtons();
        addButtons();
        addButtonListener();
    }

    private void createButtons(){
        confirmButton = new Button("Confirm");
        deleteButton = new Button("-");
        addButton = new Button("+");
    }

    private void addButtons(){
        buttonBar.getButtons().add(deleteButton);
        buttonBar.getButtons().add(addButton);
    }

    private void addButtonListener(){
        for(Node button : buttonBar.getButtons()) {
            Button temp = (Button) button;
            temp.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    if(actionEvent.getSource() == addButton){
                        System.out.println("add button pressed");
                    }
                    else{
                        System.out.println("delete button pressed");
                    }
                }
            });
        }
    }

    private void createInfoBox(){
        infoBox = new BudgetListInfoBox();
    }

    private void setLayout(){
        super.setTop(headerBox);
        super.setCenter(infoBox);
        super.setLeft(budgetListVBox);
        super.setBottom(buttonBar);

        // TODO: just finished updating fields. fix resize issue. move buttonbar somewhere that makes more sense.

    }

    public void registerBudgetController(BudgetListController controller){
        this.budgetListController = controller;
        this.budgetListVBox.registerBudgetListController(this.budgetListController);
    }

    public void setSelectedBudgetByIndex(int index){
        System.out.println("Budget selected: " + index);
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
