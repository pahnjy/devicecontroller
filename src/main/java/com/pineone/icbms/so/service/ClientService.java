package com.pineone.icbms.so.service;

import java.net.MalformedURLException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Service;

/**
 * Created by use on 2015-10-12.
 */
@Service
public class ClientService implements IClientService
{

	public static final String	SIDOMAIN	= "http://localhost:8090/";
	public static final String	SICOMMAND	= "http://116.124.171.125:8080/si/command";

	public static final String	SIDEVICECONTROL			= "http://localhost:8090/si/controlmessage";
	public static final String	ACCEPT_ENCODING			= "Accept-Encoding";
	public static final String	ACCEPT_ENCODING_IDNTITY	= "identity";
	public static final String	CONTENT_TYPE			= "Content-Type";
	public static final String	CONTENT_TYPE_JSON		= "application/json";
	public static final String	ENDODING_UTF8			= "UTF-8";

	@Override
	public HttpResponse requestData(String uri, String data)
	{
		HttpResponse response = null;

		try
		{
			HttpClient client = new DefaultHttpClient();
			HttpPost post = new HttpPost(uri);
			post.setHeader(ACCEPT_ENCODING, ACCEPT_ENCODING_IDNTITY);
			post.setHeader(CONTENT_TYPE, CONTENT_TYPE_JSON);

			HttpEntity entity = new ByteArrayEntity(
					data.getBytes(ENDODING_UTF8));
			post.setEntity(entity);
			response = client.execute(post);

			String result = EntityUtils.toString(response.getEntity());
			System.out.println("Output from Server result data .... \n");
			System.out.println(result);

		}
		catch (ClientProtocolException e)
		{
			e.printStackTrace();
		}
		catch (MalformedURLException e)
		{
			e.printStackTrace();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

		return response;
	}

	@Override
	public HttpResponse requestData(String uri)
	{
		HttpResponse response = null;

		try
		{
			HttpClient client = new DefaultHttpClient();
			HttpGet get = new HttpGet(uri);
			get.setHeader(ACCEPT_ENCODING, ACCEPT_ENCODING_IDNTITY);
			get.setHeader(CONTENT_TYPE, CONTENT_TYPE_JSON);

			response = client.execute(get);

			String result = EntityUtils.toString(response.getEntity());
			System.out.println("Output from Server result data .... \n");
			System.out.println(result);

		}
		catch (ClientProtocolException e)
		{
			e.printStackTrace();
		}
		catch (MalformedURLException e)
		{
			e.printStackTrace();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

		return response;
	}
}
