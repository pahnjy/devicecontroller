package com.pineone.icbms.so.service;


import com.pineone.icbms.so.model.DeviceControlMessage;
import com.pineone.icbms.so.model.VirtualDeviceControlMessage;

/**
 * Created by use on 2015-10-01.
 */

public interface IOneM2MService
{

	/**
	 * SI연동 데이터 규격으로 데이터 변경 처리 하는 서비스<BR/>
	 *
	 */

	/**
	 * create oneM2MMessage
	 * 
	 * @param message
	 * @return SI연동 data로 변경.
	 */

    DeviceControlMessage oneM2MCreateMessage(VirtualDeviceControlMessage message);

}
