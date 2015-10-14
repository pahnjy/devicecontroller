package com.pineone.icbms.so.service;

import com.pineone.icbms.so.model.ResponseMessage;
import com.pineone.icbms.so.model.ResultMessage;
import org.apache.http.HttpResponse;
import org.springframework.stereotype.Service;

/**
 * Created by use on 2015-10-14.
 */

@Service
public class IResponseDataService implements ResponseDataService {

    public final String RESPONSE_SUCCESS = "success";
    public final String RESPONSE_FAILURE = "failure";
    public final String RESPONSE_SUCCESS_CODE = "200";
    public final String RESPONSE_FIALURE_CODE = "400";
    public final String RESPONSE_SUCCESS_ONEM2MCODE = "2000";

    @Override
    public ResponseMessage ResponseMessageByResultMessage(ResultMessage message) {
        // ResultMessage를 분석후 결과 데이터를 전달.

        ResponseMessage responseMessage = new ResponseMessage();

        if(RESPONSE_SUCCESS_ONEM2MCODE.equals(message.get_resultCode()) || RESPONSE_SUCCESS.equals(message.get_result())){
            responseMessage.setCode(RESPONSE_SUCCESS_CODE);
            responseMessage.setMessage(RESPONSE_SUCCESS);
        } else {
            responseMessage.setCode(RESPONSE_FIALURE_CODE);
            responseMessage.setMessage(RESPONSE_FAILURE);
            responseMessage.setContent("error 경위 작성.");
        }

        return responseMessage;
    }

    @Override
    public ResponseMessage ResponseMessageByHttpResponse(HttpResponse response) {
        return null;
    }
}
