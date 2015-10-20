package com.pineone.icbms.so.controller;

import com.pineone.icbms.so.driver.IDeviceDriver;
import com.pineone.icbms.so.driver.LGHD3xxLightDeviceDriver;
import com.pineone.icbms.so.model.VirtualDeviceControlMessage;
import com.pineone.icbms.so.service.IResponseDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * DeviceController
 */
@RestController
public class DeviceController {

    @Autowired
    IResponseDataService responseDataService;


    List<IDeviceDriver> deviceDrivers;

    /**
     * 디바이스 제어요청 메시지 전달. <BR/>
     * @param message VDCM
     * @return 결과 확인값 return
     */

    @RequestMapping(value = "so/controllmessage", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.OK)
    public String deviceControl(@RequestBody VirtualDeviceControlMessage message) {

        return findDeviceDriverForModel(message.getDevicemodel()).excute(message);
    }

    /**
     * initialization DeviceDriver
     */
    public void initDeviceDriver(){

        LGHD3xxLightDeviceDriver lgDevice = new LGHD3xxLightDeviceDriver();
        if(deviceDrivers == null){
            deviceDrivers = new ArrayList<>();
        }
        deviceDrivers.add(lgDevice);
    }


    /**
     * find DeviceDrive for Model
     * @param model DeviceModel
     * @return DeviceDriver
     */
    public IDeviceDriver findDeviceDriverForModel(String model){
        initDeviceDriver();
        for(IDeviceDriver devicedriver : deviceDrivers){
            List<String> deviceModel = devicedriver.getModels();
            for(String device : deviceModel){
                if(model.equals(device)){
                    return devicedriver;
                }
            }
        }
        /**deviceDrivers 처리<BR/>
         */
        return null;
    }
}
