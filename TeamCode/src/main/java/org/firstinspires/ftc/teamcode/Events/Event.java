package org.firstinspires.ftc.teamcode.Events;

import java.util.ArrayList;

public class Event<T> {
    public ArrayList<EventUser> subscribers = new ArrayList<>();

    public void subscribe(EventUser eventUser){
        subscribers.add(eventUser);
    }

    public void unSubscribe(EventUser eventUser){subscribers.remove(eventUser);}

    public T data;
    public void publish(T data){
        this.data = data;
        for (EventUser i: subscribers) {
            i.onEvent(this);
        }
    }
    
}
