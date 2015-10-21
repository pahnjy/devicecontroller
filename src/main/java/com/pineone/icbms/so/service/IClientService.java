package com.pineone.icbms.so.service;

import org.apache.http.HttpResponse;

/**
 * Created by use on 2015-09-23.
 */
public interface IClientService
{

    HttpResponse requestData(String uri, String data);
	HttpResponse requestData(String uri);

}
