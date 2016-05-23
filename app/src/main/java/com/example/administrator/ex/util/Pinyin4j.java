package com.example.administrator.ex.util;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.HanyuPinyinVCharType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

/**
 * Created by Administrator on 2016/5/16.
 */
public class Pinyin4j {
    public static String getPinyin(String src,boolean isUpperCase){
        char[] charArray =null;
        charArray = src.toCharArray();
        String[] strArray = new String[charArray.length];
        HanyuPinyinOutputFormat hanyuPinyinOutputFormat = new HanyuPinyinOutputFormat();
        if(isUpperCase){
            hanyuPinyinOutputFormat.setCaseType(HanyuPinyinCaseType.UPPERCASE);

        }else{
            hanyuPinyinOutputFormat.setCaseType(HanyuPinyinCaseType.LOWERCASE);
        }
        hanyuPinyinOutputFormat.setToneType(HanyuPinyinToneType.WITH_TONE_MARK);
        hanyuPinyinOutputFormat.setVCharType(HanyuPinyinVCharType.WITH_U_UNICODE);
    String name ="";
        //int t0 = t1.length;
        try {
            for (int i = 0; i < charArray.length; i++) {
                // 判断能否为汉字字符
                // System.out.println(t1[i]);
                if (Character.toString(charArray[i]).matches("[\\u4E00-\\u9FA5]+")) {
                    strArray = PinyinHelper.toHanyuPinyinStringArray(charArray[i], hanyuPinyinOutputFormat);// 将汉字的几种全拼都存到t2数组中
                    name += strArray[0];// 取出该汉字全拼的第一种读音并连接到字符串t4后
                } else {
                    // 如果不是汉字字符，间接取出字符并连接到字符串t4后
                    name += Character.toString(charArray[i]);
                }
            }
        } catch (BadHanyuPinyinOutputFormatCombination e) {
            e.printStackTrace();
        }
        return name;
        // String[] pinyin = PinyinHelper.toHanyuPinyinStringArray('',hanyuPinyinOutputFormat)

    }
}
