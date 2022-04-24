package com.sintrue.matrix.example.account.message_pl;

import wang.liangchen.matrix.framework.ddd.event.ApplicationEvent;
import wang.liangchen.matrix.framework.ddd.message_pl.Direction;
import wang.liangchen.matrix.framework.ddd.message_pl.MessageContract;

import java.time.Clock;

/**
 * @author Liangchen.Wang 2022-04-24 14:43
 */
@MessageContract(Direction.South)
public class AccountRegisteredEvent extends ApplicationEvent {
    public AccountRegisteredEvent(Object source) {
        super(source);
    }

    public AccountRegisteredEvent(Object source, Clock clock) {
        super(source, clock);
    }
}
