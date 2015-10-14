package com.pineone.icbms.so.service;

import com.pineone.icbms.so.model.ResponseMessage;
import com.pineone.icbms.so.model.ResultMessage;
import org.apache.http.HttpResponse;

/**
 * Created by use on 2015-10-14.
 */

public interface ResponseDataService {
    /**
     * SI�� ���� ������ ó���� ���� ����� Ȯ�� �� �����ϴ� service
     * @param message SI�� ���� �� ��� �޽���
     * @return
     */
    ResponseMessage ResponseMessageByResultMessage(ResultMessage message);

    ResponseMessage ResponseMessageByHttpResponse(HttpResponse response);

}
