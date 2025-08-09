package org.firstinspires.ftc.teamcode.EventBus.Bus;

import org.firstinspires.ftc.teamcode.EventBus.Interfaces.IEvent;
import org.firstinspires.ftc.teamcode.EventBus.Interfaces.OnEventMethod;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;


public class EventBus {
    private static final EventBus Instance = new EventBus();

    public static EventBus getInstance() {
        return Instance;
    }

    HashMap< Class<? extends IEvent>, ArrayList<OnEventMethod>> eventUsers = new HashMap<>();

    public <K,T extends IEvent<K>> void  subscribe(Class<T> eventType, OnEventMethod<K,T> onEventMethod){
        if(!eventUsers.containsKey(eventType)){
            eventUsers.put(eventType, new ArrayList<>( Arrays.asList( onEventMethod ) ));
        }else{
            eventUsers.get(eventType).add(onEventMethod);
        }
    }

    public <K,T extends IEvent<K>> void invoke(T event){
        ArrayList<OnEventMethod> subscribers = eventUsers.get(event.getClass());

        if(subscribers == null){
            return;
        }

        for (OnEventMethod i: subscribers) {
            i.onEvent(event);
        }
    }
}
