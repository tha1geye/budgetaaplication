package com.lacray.controller.events;

public class BudgetEvent extends AppEvent{
    public BudgetEvent(EventType type){
        super(type);
    }

    public EventType getEventType(){
        return this.type;
    }
}
