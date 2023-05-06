package com.sintrue.example.generator.ddd.hr.southbound_acl.adapter.client;


import com.sintrue.example.generator.ddd.hr.southbound_acl.port.client.StaffClient;
import org.springframework.stereotype.Component;
import wang.liangchen.matrix.framework.ddd.southbound_acl.adapter.Adapter;
import wang.liangchen.matrix.framework.ddd.southbound_acl.adapter.IClientAdapter;
import wang.liangchen.matrix.framework.ddd.southbound_acl.port.PortType;

/**
 * @author  2023-05-06 16:39:10
 */
@Component
@Adapter(PortType.Client)
public class StaffClientImpl implements StaffClient, IClientAdapter {
}