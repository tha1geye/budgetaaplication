package com.lacray.controller.events;

public class BudgetEvent {
    private BudgetEventType type;

    public BudgetEvent(BudgetEventType type){
        this.type = type;
    }

    public BudgetEventType getEventType(){
        return this.type;
    }
}
