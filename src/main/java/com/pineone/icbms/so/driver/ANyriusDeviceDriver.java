package com.pineone.icbms.so.driver;

import com.pineone.icbms.so.model.OperationType;
import com.pineone.icbms.so.model.ResponseMessage;
import com.pineone.icbms.so.model.VirtualDeviceControlMessage;

import java.util.List;

/**
 * Created by use on 2015-10-21.
 */
public abstract class ANyriusDeviceDriver implements IDeviceDriver {

    public String excute(VirtualDeviceControlMessage vdcm){

        switch (vdcm.getOntologyref()){
            case OperationType.POWER_CONTROL:
                powerControl(vdcm);
                break;
        }

        return null;
    }

    abstract String powerControl(VirtualDeviceControlMessage vdcm);
}
