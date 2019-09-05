package com.cumt.util;

import java.util.UUID;

public class UUIDUtils {

    private UUIDUtils(){};
    public static String getUuid()
    {
        return UUID.randomUUID().toString().replace("-","");
    }
}
