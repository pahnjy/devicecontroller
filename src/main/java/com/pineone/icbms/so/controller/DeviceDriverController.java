package com.pineone.icbms.so.controller;

import com.pineone.icbms.so.model.DeviceDriver;
import com.pineone.icbms.so.model.VirtualDeviceControlMessage;

/**
 * Created by use on 2015-10-14.
 */
public interface DeviceDriverController {

    String execute(VirtualDeviceControlMessage message);

    String getModel();


}
