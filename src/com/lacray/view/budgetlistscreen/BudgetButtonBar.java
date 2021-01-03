package com.lacray.view.budgetlistscreen;

import com.lacray.controller.EventCoordinator;
import com.lacray.controller.events.BudgetEvent;
import com.lacray.controller.events.BudgetEventType;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.layout.HBox;

public class BudgetButtonBar extends HBox {
    private EventCoordinator eventCoordinator;

    private ButtonBar buttonBar;
    private Button addButton;
    private Button deleteButton;
    private Button confirmButton;

    public BudgetButtonBar(EventCoordinator eventCoordinator){
        super();
        this.eventCoordinator = eventCoordinator;

        createComponents();
        createChildren();
        setLayout();
    }

    private void createComponents(){
        //this.budgetListController = null;
    }

    private void createChildren(){
        createButtonBar();
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
                        eventCoordinator.handleBudgetEvent(new BudgetEvent(BudgetEventType.ADD_BUDGET));
                    }
                    else{
                        System.out.println("delete button pressed");
                    }
                }
            });
        }
    }

    private void setLayout(){
        super.getChildren().add(buttonBar);
    }
}
