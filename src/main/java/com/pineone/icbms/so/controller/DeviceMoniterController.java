package com.pineone.icbms.so.controller;

import com.pineone.icbms.so.model.ResponseMessage;
import com.pineone.icbms.so.model.ResultMessage;
import com.pineone.icbms.so.service.IResponseDataService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class DeviceMoniterController
{
    private final Logger log = LoggerFactory.getLogger(DeviceMoniterController.class);

    @Autowired
    IResponseDataService responseDataService;
    /**
     * 응답 결과를 받아서 결과 여부를 판단함.
     * @param message
     * @param id
     * @return
     */
    @RequestMapping(value = "so/resources/pdcm/{id}", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.OK)
    public ResponseMessage controlMessage(@RequestBody ResultMessage message, @PathVariable String id) {
        log.debug("insert device moniter controller");

        /** ResultMessage의 정책에 따라 response 데이터 정책 필요
         * ResultMessage 받아서 DB에 결과값 update 및 결과 내용 responseMessage에 담아서 전달.
         * DB Update process
         */

        return responseDataService.responseMessageByResultMessage(message);
    }
}
