package com.sintrue.example.generator.ddd.hr.southbound_acl.adapter.file;


import com.sintrue.example.generator.ddd.hr.southbound_acl.port.file.StaffFile;
import org.springframework.stereotype.Component;
import wang.liangchen.matrix.framework.ddd.southbound_acl.adapter.Adapter;
import wang.liangchen.matrix.framework.ddd.southbound_acl.adapter.IFileAdapter;
import wang.liangchen.matrix.framework.ddd.southbound_acl.port.PortType;

/**
 * @author  2023-05-06 16:39:10
 */
@Component
@Adapter(PortType.Publisher)
public class StaffFileImpl implements StaffFile, IFileAdapter {
}