package com.lacray.controller;

import com.lacray.controller.events.AppEvent;
import com.lacray.model.Budget;
import com.lacray.view.budgetlistscreen.BudgetsListRoot;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import java.util.ArrayList;
import java.util.List;


public class GUIPresentationController implements PresentationController{
    private EventCoordinator eventCoordinator;
    private ObservableList<String> budgetTitles;

    //  strings
    private static final String APP_NAME = "Budget Application";

    //  UI
    private static Pane root = new Pane();
    private static BudgetsListRoot budgetsListRoot;

    public GUIPresentationController(Stage primaryStage){
        budgetTitles = null;
        eventCoordinator = null;
        budgetsListRoot = new BudgetsListRoot(this);

        Scene scene = new Scene(createContent());

        primaryStage.setScene(scene);

        primaryStage.setTitle(APP_NAME);
        primaryStage.show();
    }

    private Parent createContent(){
        root = budgetsListRoot;
        root.setPrefSize(1024, 800);

        return root;
    }

    @Override
    public void triggerAddBudgetAction() {

    }

    @Override
    public void registerEventCoordinator(EventCoordinator eventCoordinator) {
        this.eventCoordinator = eventCoordinator;
    }

    @Override
    public void handleEvent(AppEvent event) {
        switch (event.getType()){
            case ADD_BUDGET:
                System.out.println("Add budget event received");
                eventCoordinator.handleEvent(event);
                break;
            case DELETE_BUDGET:
                System.out.println("Delete budget event received");
                break;
            case GET_ALL_BUDGETS:
                System.out.println("Get all budgets event received");
                break;
            default:
                System.out.println("An event was received that I am unable to process");
                break;
        }
    }

    @Override
    public void updateBudgets(ArrayList<Budget> budgets) {
        ArrayList<String> temp = new ArrayList<>();
        for(Budget budget : budgets){
            temp.add(budget.getTitle());
        }

        budgetTitles = FXCollections.observableList(temp);
        budgetsListRoot.updateBudgets(budgetTitles);
    }

    public void requestUpdate(){
        updateBudgets();
    }

}
