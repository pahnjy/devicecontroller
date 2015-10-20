package com.pineone.icbms.so.driver;


import com.pineone.icbms.so.model.OperationType;
import com.pineone.icbms.so.model.VirtualDeviceControlMessage;

/**
 * Created by existmaster on 2015. 10. 13..
 */
public abstract class ALGDeviceDriver implements IDeviceDriver{

    public String excute(VirtualDeviceControlMessage vdcm){

        switch (vdcm.getOntologyref()){
            case OperationType.POWER_CONTROL:
                Hello();
                break;

            case OperationType.TEMP_CONTROL:
                Hello2();
                break;
        }

        return null;
    }

    abstract String Hello();
    abstract String Hello2();


}
