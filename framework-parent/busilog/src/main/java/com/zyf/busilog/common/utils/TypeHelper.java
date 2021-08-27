package com.zyf.busilog.common.utils;

import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.Reader;
import java.nio.charset.Charset;
import java.nio.charset.UnsupportedCharsetException;
import java.sql.Clob;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TypeHelper {

    protected static final Logger logger = LoggerFactory.getLogger(TypeHelper.class);

    public TypeHelper() {
    }

    public static String toString(Object s, String defaultValue) {
        if (s != null && !StrHelper.isEmpty(s.toString())) {
            if (s.getClass().isArray()) {
                try {
                    String str = "";
                    Object[] arr = (Object[])((Object[])s);

                    for(int i = 0; i < arr.length; ++i) {
                        str = str + arr[i];
                        if (i < arr.length - 1) {
                            str = str + ",";
                        }
                    }

                    return str;
                } catch (Exception var5) {
                    logger.error("将{0}转换为String型发生异常[{1}]，返回默认值：{2}", new Object[]{s, var5.getMessage(), StrHelper.isEmpty(defaultValue) ? "\"\"" : defaultValue});
                    return defaultValue;
                }
            } else {
                return s.toString();
            }
        } else {
            return defaultValue;
        }
    }

    public static String toString(Object s) {
        return toString(s, "");
    }

    public static String toString(String[] arr) {
        return toString(arr, ",");
    }

    public static String toString(String[] arr, String sep) {
        if (arr == null) {
            return "";
        } else {
            String s = "";

            for(int i = 0; i < arr.length; ++i) {
                s = s + arr[i] + (i < arr.length - 1 ? sep : "");
            }

            return s;
        }
    }

    public static Long toLong(Object value, Long defaultValue) {
        try {
            return StrHelper.isEmpty(value) ? defaultValue : Long.valueOf(toString(value));
        } catch (Exception var3) {
            logger.error("将{0}转换为Long型发生异常[{1}]，返回默认值：{2}", new Object[]{value, var3.getMessage(), defaultValue});
            return defaultValue;
        }
    }

    public static Long toLong(Object value) {
        return toLong(value, (Long)null);
    }

    public static Double toDouble(Object value, Double defaultValue) {
        try {
            return StrHelper.isEmpty(value) ? defaultValue : Double.valueOf(toString(value));
        } catch (Exception var3) {
            logger.error("将{0}转换为Double型发生异常[{1}]，返回默认值：{2}", new Object[]{value, var3.getMessage(), defaultValue});
            return defaultValue;
        }
    }

    public static Double toDouble(Object value) {
        return toDouble(value, (Double)null);
    }

    public static Integer toInteger(Object value, Integer defaultValue) {
        try {
            return StrHelper.isEmpty(value) ? defaultValue : Integer.valueOf(toString(value));
        } catch (Exception var3) {
            logger.error("将{0}转换为Integer型发生异常[{1}]，返回默认值：{2}", new Object[]{value, var3.getMessage(), defaultValue});
            return defaultValue;
        }
    }

    public static Integer toInteger(Object value) {
        return toInteger(value, (Integer)null);
    }

    public static Float toFloat(Object value, Float defaultValue) {
        try {
            return StrHelper.isEmpty(value) ? defaultValue : Float.valueOf(toString(value));
        } catch (Exception var3) {
            logger.error("将{0}转换为Float型发生异常[{1}]，返回默认值：{2}", new Object[]{value, var3.getMessage(), defaultValue});
            return defaultValue;
        }
    }

    public static Float toFloat(Object value) {
        return toFloat(value, (Float)null);
    }

    public static int toInt(Object value, int defaultValue) {
        if (value instanceof Integer) {
            return (Integer)value;
        } else {
            return value instanceof Long ? ((Long)value).intValue() : toInteger(value + "", defaultValue);
        }
    }

    public static int toInt(Object value) {
        return toInt(value, 0);
    }

    public static int toInt(Date date) {
        String s = DateHelper.getDateString(date, "yyyyMMdd");
        return toInt((Object)s);
    }

    public static Short toShort(Object value, Short defaultValue) {
        try {
            return StrHelper.isEmpty(value) ? defaultValue : Short.valueOf(toString(value, "").split("\\.")[0]);
        } catch (Exception var3) {
            logger.error("将{0}转换为Short型发生异常[{1}]，返回默认值：{2}", new Object[]{value, var3.getMessage(), defaultValue});
            return defaultValue;
        }
    }

    public static Short toShort(Object value) {
        return toShort(value, (Short)null);
    }

    public static Date toDate(String s, Date defaultValue) {
        try {
            return StrHelper.isEmpty(s) ? defaultValue : DateHelper.stringToDate(s);
        } catch (Exception var3) {
            logger.error("将{0}转换为Date型发生异常[{1}]，返回默认值：{2}", new Object[]{s, var3.getMessage(), defaultValue});
            return defaultValue;
        }
    }

    public static Date toDate(String s) {
        return toDate(s, (Date)null);
    }

    public static java.sql.Date toSqlDate(String s, java.sql.Date defaultValue) {
        return (java.sql.Date)toDate(s, defaultValue);
    }

    public static java.sql.Date toSqlDate(String s) {
        return (java.sql.Date)toDate(s, (Date)null);
    }

    public static String toHEX(Object obj) {
        byte[] b = toString(obj).getBytes(getDefaultCharset());
        String hs = "";
        String stmp = "";

        for(int n = 0; n < b.length; ++n) {
            stmp = Integer.toHexString(b[n] & 255);
            if (stmp.length() == 1) {
                hs = hs + "0" + stmp;
            } else {
                hs = hs + stmp;
            }
        }

        return hs.toUpperCase();
    }

    private static Charset getDefaultCharset() {
        String encoding = System.getProperty("file.encoding", "UTF-8");
        try {
            return Charset.forName(encoding);
        } catch (UnsupportedCharsetException e) {
            return Charset.forName("UTF-8");
        }
    }

    public static Map<String, Object> toMap(Object obj) {
        if (StrHelper.isEmpty(obj)) {
            return new HashMap();
        } else if (isMap(obj)) {
            return (Map)obj;
        } else {
            try {
                String jsonStr = JSON.toJSONString(obj);
                return (Map)JSON.parseObject(jsonStr,Map.class);
            } catch (Exception var2) {
                logger.error("将{0}转换为Map型发生异常[{1}]，值类型必须是Map或者VO", new Object[]{obj, var2.getMessage()});
                return null;
            }
        }
    }

    public static String clobToString(Clob clob) {
        String clobStr = null;
        Reader inStream = null;

        try {
            if (clob == null) {
                Object var17 = clobStr;
                return (String)var17;
            }

            inStream = clob.getCharacterStream();
            char[] c = new char[(int)clob.length()];
            inStream.read(c);
            clobStr = new String(c);
            String var4 = clobStr;
            return var4;
        } catch (Exception var15) {
            logger.error(var15.getMessage(), new Object[]{var15});
        } finally {
            if (inStream != null) {
                try {
                    inStream.close();
                } catch (IOException var14) {
                    var14.printStackTrace();
                }
            }

        }

        return clobStr;
    }

    public static boolean isArray(Object value) {
        return value != null && value.getClass().isArray();
    }

    public static boolean isList(Object value) {
        return value instanceof List;
    }

    public static boolean isMap(Object value) {
        return value instanceof Map;
    }

    public static boolean isDate(Object value) {
        return value instanceof Date;
    }

    public static boolean isNumber(Object value) {
        if (value == null) {
            return false;
        } else if (value instanceof Number) {
            return true;
        } else if (value instanceof String) {
            try {
                Double.parseDouble((String)value);
                return true;
            } catch (NumberFormatException var2) {
                return false;
            }
        } else {
            return false;
        }
    }

    public static boolean isPrimitive(Object value) {
        return value == null || value instanceof Comparable;
    }

//    public static <T> T[] merge(T[]... sources) {
//        int length = 0;
//        T[] first = null;
//        Object[][] var3 = sources;
//        int offset = sources.length;
//
//        for(int var5 = 0; var5 < offset; ++var5) {
//            T[] source = var3[var5];
//            if (source != null) {
//                if (first == null) {
//                    first = source;
//                }
//
//                length += source.length;
//            }
//        }
//
//        if (first == null) {
//            return null;
//        } else {
//            T[] result = Arrays.copyOf(first, length);
//            offset = first.length;
//            Object[][] var10 = sources;
//            int var11 = sources.length;
//
//            for(int var7 = 0; var7 < var11; ++var7) {
//                T[] source = var10[var7];
//                if (source != null && !source.equals(first)) {
//                    System.arraycopy(source, 0, result, offset, source.length);
//                    offset += source.length;
//                }
//            }
//
//            return result;
//        }
//    }

}
