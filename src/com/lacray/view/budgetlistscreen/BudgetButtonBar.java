package com.lacray.view.budgetlistscreen;

import com.lacray.controller.PresentationController;
import com.lacray.controller.events.BudgetEvent;
import com.lacray.controller.events.EventType;
import javafx.event.ActionEvent;

import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.layout.HBox;

public class BudgetButtonBar extends HBox {
    private PresentationController presentationController;

    private ButtonBar buttonBar;
    private Button addButton;
    private Button deleteButton;
    private Button confirmButton;

    public BudgetButtonBar(PresentationController presentationController){
        super();
        this.presentationController = presentationController;

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
                        handleAddButtonPressed();
                    }
                    else{
                        handleDeleteButtonPressed();
                    }
                }
            });
        }
    }

    private void handleAddButtonPressed(){
        presentationController.handleEvent(new BudgetEvent(EventType.ADD_BUDGET));
    }

    private void handleDeleteButtonPressed(){
        presentationController.handleEvent(new BudgetEvent(EventType.DELETE_BUDGET));
    }

    private void setLayout(){
        super.getChildren().add(buttonBar);
    }
}
