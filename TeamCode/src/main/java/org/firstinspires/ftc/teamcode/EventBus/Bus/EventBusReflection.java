package org.firstinspires.ftc.teamcode.EventBus.Bus;

import org.firstinspires.ftc.teamcode.EventBus.Interfaces.IEvent;
import org.firstinspires.ftc.teamcode.EventBus.Interfaces.IEventUser;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class EventBusReflection {
    private static final EventBusReflection Instance = new EventBusReflection();
    public static EventBusReflection getInstance() {
        return Instance;
    }

    HashMap< Class<? extends IEvent<?>>, ArrayList<IEventUser> > eventsUsers = new HashMap<>();

    public <T extends IEvent<?>> void subscribe(Class<T> eventType,IEventUser eventUser){
        if(!eventsUsers.containsKey(eventType)){
            eventsUsers.put(eventType, new ArrayList<>( Arrays.asList( eventUser ) ));
        }else{
            eventsUsers.get(eventType).add(eventUser);
        }
    }

    private final MethodHandles.Lookup lookup = MethodHandles.publicLookup();
    public <T extends IEvent<?>> void raise(T event) throws Throwable {
        if(!eventsUsers.containsKey(event.getClass())){return;}


        MethodType methodType = MethodType.methodType(void.class, event.getClass());

        ArrayList<IEventUser> subscribers = eventsUsers.get(event.getClass());
        for (IEventUser i: subscribers) {
            MethodHandle method =  lookup.findVirtual(i.getClass(),"onEvent",methodType);
            method.invokeExact(i,event);
        }
    }
}
