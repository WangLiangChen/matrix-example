package com.sintrue.example.generator.ddd.hr.southbound_acl.adapter.oss;


import com.sintrue.example.generator.ddd.hr.southbound_acl.port.oss.StaffOSS;
import org.springframework.stereotype.Component;
import wang.liangchen.matrix.framework.ddd.southbound_acl.adapter.Adapter;
import wang.liangchen.matrix.framework.ddd.southbound_acl.adapter.IOSSAdapter;
import wang.liangchen.matrix.framework.ddd.southbound_acl.port.PortType;

/**
 * @author  2023-05-06 16:39:10
 */
@Component
@Adapter(PortType.Publisher)
public class StaffOSSImpl implements StaffOSS, IOSSAdapter {
}