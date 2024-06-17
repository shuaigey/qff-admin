package org.example.qff.common.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author liufan
 * @version 1.0
 * @date 2024/3/7 15:17
 **/
public class TimeUtil {

    public static String nowTime() {
        LocalDateTime localDateTime = LocalDateTime.now();
        String time = localDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        return time;
    }
}
