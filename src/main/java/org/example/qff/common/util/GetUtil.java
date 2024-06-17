package org.example.qff.common.util;

import net.sourceforge.pinyin4j.PinyinHelper;
import org.springframework.util.StringUtils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * @author liufan
 * @version 1.0
 * @date 2024/3/7 15:10
 **/
public class GetUtil {
    /*生成随机的UUID*/
    public static String getUUID() {
        String uuid = null;
        for (int i = 0; i < 5; i++) {
            String s = UUID.randomUUID().toString();
            uuid = s.substring(0, 8) + s.substring(9, 13) + s.substring(14, 18) + s.substring(19, 23) + s.substring(24);
        }
        return uuid;
    }
    /*生成永远不同的12位数*/
    public static String getId(){
        SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyMMddHHmmss");
        return sdf.format(new Date());
    }
    //中文首字母大写
    public static String getPinYinHeadChar(String str) {
        if (StringUtils.isEmpty(str)) {
            return "";
        }
        String convert = "";
        for (int j = 0; j < str.length(); j++) {
            char word = str.charAt(j);
            // 提取汉字的首字母
            String[] pinyinArray = PinyinHelper.toHanyuPinyinStringArray(word);
            if (pinyinArray != null) {
                convert += pinyinArray[0].charAt(0);
            }
            else {
                convert += word;
            }
        }

        convert = convert.trim().replace(" ", "");
        return convert.toLowerCase();
    }

}
