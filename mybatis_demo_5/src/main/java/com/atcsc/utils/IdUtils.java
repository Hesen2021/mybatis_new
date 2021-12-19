package com.atcsc.utils;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import org.junit.Test;

import java.util.UUID;

public class IdUtils {

    public static String genId(){
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    @Test
    public void testUuid() {
        System.out.println(genId());
    }
}
