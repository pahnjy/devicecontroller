package com.pineone.icbms.so.driver;


import com.pineone.icbms.so.model.VirtualDeviceControlMessage;

import java.util.List;

/**
 * Created by existmaster on 2015. 10. 14..
 */
public interface IDeviceDriver {

    String excute(VirtualDeviceControlMessage vdcm);

    List<String> getModels();

}
