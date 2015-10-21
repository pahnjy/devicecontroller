package com.pineone.icbms.so.driver;


import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by existmaster on 2015. 10. 14..
 */
@Component
public class LGHD3xxLightDeviceDriver extends ALGDeviceDriver {

    List<String> models = Arrays.asList("LGHD394", "LGHD340");

    @Override
    public List<String> getModels() {
        return this.models;
    }

    @Override
    String Hello() {
        return "Helloahn";
    }

    @Override
    String Hello2() {
        return "Helloahn2";
    }
}
