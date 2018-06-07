package cn.hancang.www.utils.conmonUtil;

import java.util.Collection;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 集合操作工具类
 */
public class CollectionUtils {

    /**
     * 判断集合是否为null或者0个元素
     *
     * @param c
     * @return
     */
    public static boolean isNullOrEmpty(Collection c) {
        if (null == c || c.isEmpty()) {
            return true;
        }
        return false;
    }

    /**
     * char[]转换位String[]
     */
    public static String[] charToStringArray(char[] data) {

        String[] strArr = new String[data.length];
        for (int i = 0; i < strArr.length; i++) {
            strArr[i] = String.valueOf(data[i]);
        }
        return strArr;
    }

    /**
     * 判断邮箱是否合法
     *
     * @param email
     * @return
     */
    public static boolean isEmail(String email) {
        if (null == email || "".equals(email)) return false;
        //Pattern p = Pattern.compile("\\w+@(\\w+.)+[a-z]{2,3}"); //简单匹配
        Pattern p = Pattern.compile("\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*");//复杂匹配
        Matcher m = p.matcher(email);
        return m.matches();
    }

    /**
     * 判断手机号是否正确
     *
     * @param mobiles
     * @return
     */
    public static boolean isMobileNO(String mobiles) {
        Pattern p = Pattern.compile("^((13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$");
        Matcher m = p.matcher(mobiles);
        return m.matches();
    }

    /**
     * list 集合 转换成  String 字符串
     */
    public static String listToString(List list) {
        String s = "";
        for (int i = 0; i < list.size(); i++) {
            if (i != list.size() - 1) {
                s += list.get(i) + ",";
            } else {
                s += list.get(i);
            }
        }
        return s;
    }

/*    public static ArrayList<ChooseBean1> stringsToList(String s1, String s2, String s3) {
        ArrayList<ChooseBean1> list = new ArrayList<>();
        String[] strings1 = s1.split(",");
        String[] strings2 = s2.split(",");
        String[] strings3 = s3.split(",");
        for (int i = 0; i < strings1.length; i++) {
            list.add(new ChooseBean1(Integer.parseInt(strings1[i]), strings2[i], Integer.parseInt(strings3[i])));
        }
        return list;
    }

    public static ArrayList<ChooseBean1> stringsToList(String s1, String s2) {
        ArrayList<ChooseBean1> list = new ArrayList<>();
        String[] strings1 = s1.split(",");
        String[] strings2 = s2.split(",");
        for (int i = 0; i < strings1.length; i++) {
            list.add(new ChooseBean1(Integer.parseInt(strings1[i]), strings2[i], 0));
        }
        return list;
    }

    *//**
     * String 转换成 list 集合
     *//*
    public static ArrayList<String> stringToList(String s) {
        ArrayList<String> list = new ArrayList<>();
        String[] strings = s.split(",");
        for (String s1 : strings) {
            list.add(s1);
        }
        return list;
    }

    *//**
     * String 转换成 list 集合
     *//*
    public static ArrayList<Integer> stringToListint(String s) {
        ArrayList<Integer> list = new ArrayList<>();
        String[] strings = s.split(",");
        for (String s1 : strings) {
            if (!s1.equals(""))
                list.add(Integer.parseInt(s1));
        }
        return list;
    }

    // 得到集合中的地址
    public static String arrayToString(ArrayList<ChooseBean1> list) {
        String s = "";
        for (int i = 0; i < list.size(); i++) {
            if (i != list.size() - 1) {
                s += list.get(i).getName() + ",";
            } else {
                s += list.get(i).getName();
            }
        }
        return s;
    }

    // 得到集合中的 城市id
    public static String arrayToStringId(ArrayList<ChooseBean1> list) {
        String s = "";
        for (int i = 0; i < list.size(); i++) {
            if (i != list.size() - 1) {
                s += list.get(i).getId() + ",";
            } else {
                s += list.get(i).getId();
            }
        }
        return s;
    }

    // 得到当前条目的Id
    public static String arrayToStringPo(ArrayList<ChooseBean1> list) {
        String s = "";
        for (int i = 0; i < list.size(); i++) {
            if (i != list.size() - 1) {
                s += list.get(i).getCurrentId() + ",";
            } else {
                s += list.get(i).getCurrentId();
            }
        }
        return s;
    }

    public static float ListMax(List<ForMajorEmployInfo.DataBean> sampleList) {
        try {
            float maxDevation = 0;
            int totalCount = sampleList.size();
            if (totalCount >= 1) {
                double max = Double.parseDouble(sampleList.get(0).getValue());
                for (int i = 0; i < totalCount; i++) {
                    double temp = Double.parseDouble(sampleList.get(i).getValue());
                    if (temp > max) {
                        max = temp;
                    }
                }
                maxDevation = (float) max;
            }
            return maxDevation;
        } catch (Exception ex) {
            throw ex;
        }
    }

    public static int ArrayListMax(ArrayList sampleList) {
        try {
            int maxDevation = 0;
            int totalCount = sampleList.size();
            if (totalCount >= 1) {
                double max = Double.parseDouble(sampleList.get(0).toString());
                for (int i = 0; i < totalCount; i++) {
                    double temp = Double.parseDouble(sampleList.get(i).toString());
                    if (temp > max) {
                        max = temp;
                    }
                }
                maxDevation = (int) max;
            }
            return maxDevation;
        } catch (Exception ex) {
            throw ex;
        }
    }

    public static int ArrayListMin(ArrayList sampleList) {
        try {
            int mixDevation = 0;
            int totalCount = sampleList.size();
            if (totalCount >= 1) {
                double min = Double.parseDouble(sampleList.get(0).toString());
                for (int i = 0; i < totalCount; i++) {
                    double temp = Double.parseDouble(sampleList.get(i).toString());
                    if (min > temp) {
                        min = temp;
                    }
                }
                mixDevation = (int) min;
            }
            return mixDevation;
        } catch (Exception ex) {
            throw ex;
        }
    }*/
}
