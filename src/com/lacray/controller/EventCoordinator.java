package com.lacray.controller;

import com.lacray.controller.events.BudgetEvent;
import com.lacray.controller.events.BudgetEventType;

public class EventCoordinator {
    private PresentationController presentationController;

    public EventCoordinator(PresentationController controller){
        this.presentationController = controller;
    }

    public void handleBudgetEvent(BudgetEvent event){
        if(event.getEventType() == BudgetEventType.ADD_BUDGET){
            presentationController.triggerAddBudgetAction();
        }
    }
}
