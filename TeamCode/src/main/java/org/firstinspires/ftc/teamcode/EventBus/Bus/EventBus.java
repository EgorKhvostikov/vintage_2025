package org.firstinspires.ftc.teamcode.EventBus.Bus;

import org.firstinspires.ftc.teamcode.EventBus.Interfaces.IEvent;
import org.firstinspires.ftc.teamcode.EventBus.Interfaces.IEventUser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.ConcurrentHashMap;

public class EventBus {
    private static final EventBus instance = new EventBus();
    public static EventBus getInstance() {
        return instance;
    }

    private final ConcurrentHashMap< Class <? extends IEvent<?>> , ArrayList<IEventUser> > eventUserList = new ConcurrentHashMap<>();

    public <T extends IEvent<?>> void subscribe(Class<T>  event, IEventUser<T> eventUser){
        if (eventUserList.containsKey(event)) {
            eventUserList.get(event).add(eventUser);
        } else {
            eventUserList.put(
                    event, new ArrayList<>(Arrays.asList(eventUser))
            );
        }
    }

    public <T> void invoke(IEvent<T> event){
        if(eventUserList.containsKey(event.getClass())) {
             eventUserList.get(event.getClass()).forEach(i -> i.onEvent(event));
        }
    }
}
