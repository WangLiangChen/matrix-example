package com.sintrue.example.generator.ddd.hr.southbound_acl.port.client;

import wang.liangchen.matrix.framework.ddd.southbound_acl.port.IClientPort;
import wang.liangchen.matrix.framework.ddd.southbound_acl.port.Port;
import wang.liangchen.matrix.framework.ddd.southbound_acl.port.PortType;

/**
 * @author  2023-05-06 16:39:10
 */
@Port(PortType.Client)
public interface StaffClient extends IClientPort {
}