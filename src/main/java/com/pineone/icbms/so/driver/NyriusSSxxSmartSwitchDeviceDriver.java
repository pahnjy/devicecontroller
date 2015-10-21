package com.pineone.icbms.so.driver;

import com.pineone.icbms.so.model.DeviceControlMessage;
import com.pineone.icbms.so.model.ResponseMessage;
import com.pineone.icbms.so.model.VirtualDeviceControlMessage;
import com.pineone.icbms.so.service.ClientService;
import com.pineone.icbms.so.service.DataService;
import com.pineone.icbms.so.service.IClientService;
import com.pineone.icbms.so.service.IOneM2MService;
import org.apache.http.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * Created by use on 2015-10-21.
 */
@Component
public class NyriusSSxxSmartSwitchDeviceDriver extends ANyriusDeviceDriver {

    List<String> models = Arrays.asList("SS22", "SS33", "SS44");

    @Autowired
    IOneM2MService oneM2MService;

    @Autowired
    IClientService clientService;

    @Override
    public List<String> getModels() {
        return this.models;
    }

    @Override
    String powerControl(VirtualDeviceControlMessage vdcm) {
        /**
         * oneM2M message parsing
         * message sending
         * 디바이스 제어
         */
        DeviceControlMessage controlMessage = oneM2MService.oneM2MCreateMessage(vdcm);
        HttpResponse response = clientService.requestData(ClientService.SICOMMAND, DataService.dataParsing(controlMessage));
        ResponseMessage responseMessage = DataService.responseDataParsing(response);
        return DataService.dataParsing(responseMessage);
    }
}
