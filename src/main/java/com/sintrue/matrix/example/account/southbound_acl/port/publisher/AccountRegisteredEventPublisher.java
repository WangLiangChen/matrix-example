package com.sintrue.matrix.example.account.southbound_acl.port.publisher;


import com.sintrue.matrix.example.account.message_pl.AccountRegisteredEvent;
import wang.liangchen.matrix.framework.ddd.southbound_acl.Port;
import wang.liangchen.matrix.framework.ddd.southbound_acl.PortType;

@Port(PortType.Publisher)
public interface AccountRegisteredEventPublisher {
    void publish(AccountRegisteredEvent accountRegisteredEvent);
}
