package com.lacray.controller;

import com.lacray.controller.events.AppEvent;

public class EventCoordinator {
    private PresentationController presentationController;
    private DataManager dataManager;

    public EventCoordinator(PresentationController controller){
        this.presentationController = controller;
        this.dataManager = null;
    }

    public void registerDataManager(DataManager dataManager){
        this.dataManager = dataManager;
    }

    public void handleEvent(AppEvent event){
        switch (event.getType()){
            case ADD_BUDGET:
                System.out.println("add budget event received");
                break;

            case DELETE_BUDGET:
                System.out.println("delete budget event received");
                break;

            case GET_ALL_BUDGETS:
                System.out.println("get all budget event received");
                break;

            default:
                System.out.println("An unknown event has been received. ");
                break;
        }
    }

    private void handleGetAllBudgetsEvent(){
        presentationController.updateBudgets(dataManager.getAllBudgets());
    }
}
