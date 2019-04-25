package com.example.utils;

import java.util.UUID;

/**
 * Created with IntelliJ IDEA.
 *
 * @author zhang tong
 * date: 2019/4/25 14:59
 * description:
 */
public class EsUtils {
    public static String getEsID() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }
}
