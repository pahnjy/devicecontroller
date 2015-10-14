package com.pineone.icbms.so.controller;

import com.pineone.icbms.so.model.DeviceDriver;
import com.pineone.icbms.so.model.VirtualDeviceControlMessage;
import com.pineone.icbms.so.service.ResponseDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by use on 2015-10-14.
 */
@RestController
public class DeviceController {

    @Autowired
    ResponseDataService responseDataService;

    @Autowired
    DeviceDriverController deviceDriverController;

    List<DeviceDriver> deviceDrivers;

    @RequestMapping(value = "so/controllmessage", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.OK)
    public String DeviceControl(@RequestBody VirtualDeviceControlMessage message) {

        DeviceDriver deviceDriver = findDeviceDriverForModel(message.getDevicemodel());
        //搬苞 贸府 风凭 鞘夸, responseDataService.ResponseMessageByHttpResponse()

        deviceDriverController.execute(message);

        return "";
    }



    public DeviceDriver findDeviceDriverForModel(String model){
        for(DeviceDriver devicedriver : deviceDrivers){
            if(model == deviceDriverController.getModel()){
                return devicedriver;
            }
        }
        //deviceDrivers 贸府
        return null;
    }
}
