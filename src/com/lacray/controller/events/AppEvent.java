package com.lacray.controller.events;

public class AppEvent {
    EventType type;

    public AppEvent(EventType type){
        this.type = type;
    }

    public EventType getType(){
        return this.type;
    }
}
