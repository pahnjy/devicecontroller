package com.pineone.icbms.so.service;


import com.pineone.icbms.so.model.DeviceControlMessage;
import com.pineone.icbms.so.model.VirtualDeviceControlMessage;
import org.springframework.stereotype.Component;

/**
 * Created by use on 2015-10-12.
 */
@Component
public class OneM2MService implements IOneM2MService {
    @Override
    public DeviceControlMessage oneM2MCreateMessage(VirtualDeviceControlMessage message) {

            DeviceControlMessage deviceControlMessage = new DeviceControlMessage();

            deviceControlMessage.set_uri("casebase/SAE_0021");
            deviceControlMessage.set_notificationUri(
                    "http://www.icbms.org:8080/so/resources/pdcm/" + message.getDevicename());
            deviceControlMessage.set_command(message.getOperator());
            deviceControlMessage.setCnf("text/plain:0");
            deviceControlMessage.setCon(message.getValue());

            return deviceControlMessage;

    }
}
