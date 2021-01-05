package com.lacray.view.budgetlistscreen;

import com.lacray.controller.BudgetListController;
import com.lacray.model.Budget;
import javafx.beans.Observable;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

import java.util.ArrayList;

public class BudgetListVBox extends VBox {
    //  strings
    //  components
    private BudgetsListRoot parent;

    //  UI
    private ListView<String> listView;

    private Budget selectedBudget;

    public BudgetListVBox(BudgetsListRoot parent){
        super();
        this.parent = parent;
        selectedBudget = null;
        createComponents();
        createChildren();
        setLayout();
    }

    private void createComponents(){

    }

    private void createChildren(){
        createListView();
    }

    private void createListView(){
        listView = new ListView<>();
        listView.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                updateSelection(listView.getSelectionModel().getSelectedIndex());
            }
        });
    }

    private void setLayout(){
        super.getChildren().addAll(listView);
    }

    private void updateSelection(int index){
        parent.setSelectedBudgetByIndex(index);
    }

    public void updateBudgets(ObservableList<String> budgetTitleList){
        listView.setItems(budgetTitleList);
    }
}
