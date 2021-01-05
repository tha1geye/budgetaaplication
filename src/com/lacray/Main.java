package com.lacray;

import com.lacray.controller.*;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
    //  controllers and such
    private static PresentationController presentationController;
    private static EventCoordinator eventCoordinator;
    private static DataManager dataManager;

    //  strings
    private static final String APP_NAME = "Budget Application";

    @Override
    public void start(Stage primaryStage) throws Exception{
        presentationController = new GUIPresentationController(primaryStage);
        eventCoordinator = new EventCoordinator(presentationController);
        dataManager = new DataManager();

        injectData();
        registerComponents();
    }

    private void injectData(){
        dataManager.injectData();
    }

    private static void registerComponents(){
        presentationController.registerEventCoordinator(eventCoordinator);
        dataManager.registerEventCoordinator(eventCoordinator);
        eventCoordinator.registerDataManager(dataManager);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
