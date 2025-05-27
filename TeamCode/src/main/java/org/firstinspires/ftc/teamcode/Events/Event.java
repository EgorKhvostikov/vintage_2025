package org.firstinspires.ftc.teamcode.Events;

import android.util.ArraySet;

public class Event<T> {
    public ArraySet<EventUser> subscribers;

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
