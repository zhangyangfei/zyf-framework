package com.zyf.busilog.common.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StrHelper {

    protected static final Logger logger = LoggerFactory.getLogger(StrHelper.class);

    public StrHelper() {
    }

    public static boolean like(Object str, Object... str2) throws Exception {
        return indexOf(str, str2) != -1;
    }

    public static int indexOf(Object str, Object... str2) throws Exception {
        if (str != null && str2 != null && str2.length != 0) {
            for(int i = 0; i < str2.length; ++i) {
                if (str2[i] == null) {
                    return -1;
                }

                if ((str + "").indexOf(str2[i] + "") >= 0) {
                    return i + 1;
                }
            }

            return -1;
        } else {
            return -1;
        }
    }

    public static String replaceAll(String source, String oldString, String replacement) {
        Pattern pattern = Pattern.compile(oldString);
        Matcher matcher = pattern.matcher(source);
        StringBuffer output = new StringBuffer();
        int var6 = 0;

        while(matcher.find()) {
            matcher.appendReplacement(output, replacement.replaceAll("\\{index\\}", TypeHelper.toString(var6++)));
        }

        matcher.appendTail(output);
        return output.toString();
    }

    public static String replaceLast(String text, String regex, String replacement) {
        return text.replaceFirst("(?s)" + regex + "(?!.*?" + regex + ")", replacement);
    }

    public static boolean isEmpty(String s) {
        return s == null || s.equals("") || s.toUpperCase().equals("NULL");
    }

    public static boolean isEmpty(Object s) {
        return s == null || isEmpty(s.toString());
    }

    public static List<String> getSplitStrColl(String str, String splitToken) {
        if (isEmpty(str)) {
            return new ArrayList();
        } else {
            String[] strArray = str.split(splitToken);
            return Arrays.asList(strArray);
        }
    }

    public static String getSplitStr(String str, String splitToken) {
        StringBuffer buffer = new StringBuffer();
        if (isEmpty(str)) {
            return buffer.toString();
        } else {
            String[] strArray = str.split(splitToken);
            String[] var4 = strArray;
            int var5 = strArray.length;

            for(int var6 = 0; var6 < var5; ++var6) {
                String emtArray = var4[var6];
                buffer.append(emtArray);
            }

            return buffer.toString();
        }
    }

    public static String uuid() {
        return uuid(false);
    }

    public static String uuid(boolean s) {
        String uuid = UUID.randomUUID().toString();
        if (s) {
            uuid = uuid.replace("-", "");
        }

        return uuid;
    }

    public static String random(int len) {
        if (len > 0 && len != 36) {
            String uuid = "";
            String[] chars = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz".split("");

            for(int i = 0; i < len; ++i) {
                int index = (int)Math.ceil(Math.random() * 62.0D);
                uuid = uuid + chars[index >= 0 && index <= chars.length - 1 ? index : 0];
            }

            return uuid;
        } else {
            return uuid();
        }
    }

//    public static String serialNo() {
//        return serialNo(24);
//    }

//    public static String serialNo(int digit) {
//        try {
//            return SerialNumHelper.generate(24);
//        } catch (Exception var2) {
//            logger.error("生成{0}位系统流水号发生异常", new Object[]{digit, var2});
//            return null;
//        }
//    }
//
//    public static String tradeNo() {
//        return tradeNo(32);
//    }
//
//    public static String tradeNo(int digit) {
//        try {
//            return SerialNumHelper.generate("TRADE", digit, digit > 32);
//        } catch (Exception var2) {
//            logger.error("生成{0}位交易流水号发生异常", new Object[]{digit, var2});
//            return null;
//        }
//    }

    public static String capitalizeAll(String str) {
        if (null != str && !str.isEmpty()) {
            StringBuilder s = new StringBuilder(str.length());
            boolean isUpper = true;

            for(int i = 0; i < str.length(); ++i) {
                char c = str.charAt(i);
                if ('_' == c) {
                    isUpper = true;
                } else if (isUpper) {
                    s.append(Character.toUpperCase(c));
                    isUpper = false;
                } else {
                    s.append(Character.toLowerCase(c));
                }
            }

            return s.toString();
        } else {
            return str;
        }
    }

    public static String capitalize(String str) {
        int strLen;
        if (str != null && (strLen = str.length()) != 0) {
            char firstChar = str.charAt(0);
            return Character.isUpperCase(firstChar) ? str : (new StringBuilder(strLen)).append(Character.toUpperCase(firstChar)).append(str.substring(1)).toString();
        } else {
            return str;
        }
    }

    public static String uncapitalize(String str) {
        int strLen;
        if (str != null && (strLen = str.length()) != 0) {
            char firstChar = str.charAt(0);
            return Character.isLowerCase(firstChar) ? str : (new StringBuilder(strLen)).append(Character.toLowerCase(firstChar)).append(str.substring(1)).toString();
        } else {
            return str;
        }
    }

    public static String toDecimalFormat(Object value, int precision) {
        if (isEmpty(value)) {
            return null;
        } else {
            NumberFormat formater = null;
            double num = TypeHelper.toDouble(value);
            if (precision == 0) {
                formater = new DecimalFormat("###,###");
            } else {
                StringBuffer buff = new StringBuffer();
                buff.append("###,###.");

                for(int i = 0; i < precision; ++i) {
                    buff.append("0");
                }

                formater = new DecimalFormat(buff.toString());
            }

            return formater.format(num);
        }
    }

    public static String toDecimalFormat(Object value) {
        return toDecimalFormat(value, 2);
    }

    public static String repeatString(String src, int repeats) {
        if (null != src && repeats > 0) {
            StringBuffer bf = new StringBuffer();

            for(int i = 0; i < repeats; ++i) {
                bf.append(src);
            }

            return bf.toString();
        } else {
            return src;
        }
    }

    public static String lpadString(String src, int length) {
        return lpadString(src, length, " ");
    }

    public static String lpadString(String src, int length, String single) {
//        return src != null && length > src.getBytes().length ? repeatString(single, length - src.getBytes().length) + src : src;
        return src != null && length > src.length() ? repeatString(single, length - src.length()) + src : src;
    }

    public static String rpadString(String src, int byteLength) {
        return rpadString(src, byteLength, " ");
    }

    public static String rpadString(String src, int length, String single) {
//        return src != null && length > src.getBytes().length ? src + repeatString(single, length - src.getBytes().length) : src;
        return src != null && length > src.length() ? src + repeatString(single, length - src.length()) : src;
    }

//    public static String toPYM(String chn) {
//        return toPYM(chn, true);
//    }

//    public static String toWBM(String chn) {
//        return WubiHelper.getWBCode(chn);
//    }

//    public static String toPYM(String chn, boolean first) {
//        StringBuffer result = new StringBuffer();
//        chn = chn.replaceAll("（", "").replaceAll("）", "");
//        char[] nameChar = chn.toCharArray();
//        HanyuPinyinOutputFormat defaultFormat = new HanyuPinyinOutputFormat();
//        defaultFormat.setCaseType(HanyuPinyinCaseType.UPPERCASE);
//        defaultFormat.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
//
//        for(int i = 0; i < nameChar.length; ++i) {
//            if (nameChar[i] > 128) {
//                try {
//                    String str = PinyinHelper.toHanyuPinyinStringArray(nameChar[i], defaultFormat)[0];
//                    if (first) {
//                        result.append(str.charAt(0));
//                    } else {
//                        result.append(str);
//                    }
//                } catch (Exception var8) {
//                    logger.error("字符[" + chn + "]转换为拼音字母失败，出错字符[" + nameChar[i] + "]", new Object[]{var8});
//                }
//            } else {
//                result.append(nameChar[i]);
//            }
//        }
//
//        return result.toString().toUpperCase();
//    }

    public static String getCodes() {
        return getCodes("A", 6);
    }

    public static String getCodes(String type, int length) {
        Random random = new Random();
        String letters = "";
        int i;
        if ("N".equals(type)) {
            for(i = 0; i < length; ++i) {
                letters = letters + random.nextInt(10);
            }
        } else {
            if ("M".equals(type)) {
                for(i = 0; i < length; ++i) {
                    int index = random.nextInt(3);
                    switch(index) {
                        case 0:
                            letters = letters + random.nextInt(10);
                            break;
                        case 1:
                            letters = letters + (char)(random.nextInt(26) + 65);
                            break;
                        case 2:
                            letters = letters + (char)(random.nextInt(26) + 97);
                    }
                }
            } else {
                for(i = 0; i < length; ++i) {
                    letters = letters + (char)((int)(65.0D + Math.random() * 24.0D));
                }
            }

            letters = letters.replaceAll("I", "X");
            letters = letters.replaceAll("Q", "Z");
        }

        return letters;
    }

    public static String stripXSS(String value) {
        if (!isEmpty(value)) {
            value = value.replaceAll("<", "&lt;").replaceAll(">", "&gt;");
        }

        return value;
    }

    public static boolean simpleLetterAndNumCheck(String value) {
        return simpleLetterAndNumCheck(value, 6);
    }

    public static boolean simpleLetterAndNumCheck(String value, int length) {
        boolean isValidate = false;
        int i = 0;

        for(int counter = 1; i < value.length() - 1; ++i) {
            int currentAscii = Integer.valueOf(value.charAt(i));
            int nextAscii = Integer.valueOf(value.charAt(i + 1));
            if ((rangeInDefined(currentAscii, 48, 57) || rangeInDefined(currentAscii, 65, 90) || rangeInDefined(currentAscii, 97, 122)) && (rangeInDefined(nextAscii, 48, 57) || rangeInDefined(nextAscii, 65, 90) || rangeInDefined(nextAscii, 97, 122))) {
                if (Math.abs(nextAscii - currentAscii) == 1) {
                    ++counter;
                } else {
                    counter = 1;
                }
            }

            if (counter >= length) {
                return !isValidate;
            }
        }

        return isValidate;
    }

    public static boolean rangeInDefined(int current, int min, int max) {
        return Math.max(min, current) == Math.min(current, max);
    }

    public static String trim(Object s) {
        String str = TypeHelper.toString(s);
        return str.trim();
    }

    /**
     * 去除首尾指定字符
     * @param str 字符串
     * @param element 指定字符
     * @return
     */
    public static String trimFirstAndLastChar(String str, String element){
        boolean beginIndexFlag = true;
        boolean endIndexFlag = true;
        do{
            int beginIndex = str.indexOf(element) == 0 ? 1 : 0;
            int endIndex = str.lastIndexOf(element) + 1 == str.length() ? str.lastIndexOf(element) : str.length();
            str = str.substring(beginIndex, endIndex);
            beginIndexFlag = (str.indexOf(element) == 0);
            endIndexFlag = (str.lastIndexOf(element) + 1 == str.length());
        } while (beginIndexFlag || endIndexFlag);
        return str;
    }

}
