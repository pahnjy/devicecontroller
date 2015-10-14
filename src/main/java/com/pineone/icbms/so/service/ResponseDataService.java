package com.pineone.icbms.so.service;

import com.pineone.icbms.so.model.ResponseMessage;
import com.pineone.icbms.so.model.ResultMessage;
import org.apache.http.HttpResponse;

/**
 * Created by use on 2015-10-14.
 */

public interface ResponseDataService {
    /**
     * SI로 부터 데이터 처리후 응답 결과를 확인 후 전달하는 service
     * @param message SI로 부터 온 결과 메시지
     * @return
     */
    ResponseMessage ResponseMessageByResultMessage(ResultMessage message);

    ResponseMessage ResponseMessageByHttpResponse(HttpResponse response);

}
