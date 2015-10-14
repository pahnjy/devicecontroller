package com.pineone.icbms.so.model;

/**
 * Created by use on 2015-10-14.
 */
public class DeviceDriver
{

	String	id;
	String	devicemodel;

	public DeviceDriver()
	{
	}

	public DeviceDriver(String id, String devicemodel)
	{
		this.id = id;
		this.devicemodel = devicemodel;
	}

	public String getId()
	{
		return id;
	}

	public void setId(String id)
	{
		this.id = id;
	}

	public String getDevicemodel()
	{
		return devicemodel;
	}

	public void setDevicemodel(String devicemodel)
	{
		this.devicemodel = devicemodel;
	}

}
