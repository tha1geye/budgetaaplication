package com.lacray;

import com.lacray.controller.BudgetListController;
import com.lacray.controller.EventCoordinator;
import com.lacray.controller.GUIPresentationController;
import com.lacray.controller.PresentationController;
import com.lacray.model.Budget;
import com.lacray.view.budgetlistscreen.BudgetsListRoot;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.time.LocalDate;

public class Main extends Application {
    //  controllers and such
    private static BudgetListController budgetListController = new BudgetListController();
    private static PresentationController presentationController = new GUIPresentationController();
    private static EventCoordinator eventCoordinator = new EventCoordinator(presentationController);

    //  strings
    private static final String APP_NAME = "Budget Application";

    //  UI
    private static Pane root = new Pane();
    private static BudgetsListRoot budgetsListRoot = new BudgetsListRoot();

    @Override
    public void start(Stage primaryStage) throws Exception{
        injectData();
        registerComponents();

        Scene scene = new Scene(createContent());

        primaryStage.setScene(scene);

        primaryStage.setTitle(APP_NAME);
        primaryStage.show();
    }

    private void injectData(){
        //  inject budgets
        budgetListController.addBudget(new Budget("July 2020", LocalDate.of(2020, 7, 1)));
        budgetListController.addBudget(new Budget("June 2020", LocalDate.of(2020, 6, 1)));
    }

    private static void registerComponents(){
        budgetsListRoot.registerBudgetController(budgetListController);
        budgetsListRoot.registerEventCoordinator(eventCoordinator);
    }

    private void setSceneListener(Scene scene){
        //        scene.setOnKeyPressed(e -> {
//            switch (e.getCode()){
//                case A:
//                    player.moveLeft();
//                    break;
//            }
//        });
    }

    private Parent createContent(){
        root = budgetsListRoot;
        root.setPrefSize(1024, 800);

        return root;
    }


    public static void main(String[] args) {
        launch(args);
    }
}
