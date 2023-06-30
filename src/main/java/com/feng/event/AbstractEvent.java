package com.feng.event;

import org.springframework.context.ApplicationEvent;

public class AbstractEvent extends ApplicationEvent {
    public AbstractEvent(Object source) {
        super(source);
    }
}
