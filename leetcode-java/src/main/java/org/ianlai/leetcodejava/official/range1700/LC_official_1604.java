package org.ianlai.leetcodejava.official.range1700;

import java.time.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class LC_official_1604 {
    public static void main(String[] args) {

    }

    /*
     * 力扣公司的员工都使用员工卡来开办公室的门。每当一个员工使用一次他的员工卡，安保系统会记录下员工的名字和使用时间。如果一个员工在一小时时间内使用员工卡的次数大于等于三次，这个系统会自动发布一个 警告 。

给你字符串数组 keyName 和 keyTime ，其中 [keyName[i], keyTime[i]] 对应一个人的名字和他在 某一天 内使用员工卡的时间。

使用时间的格式是 24小时制 ，形如 "HH:MM" ，比方说 "23:51" 和 "09:49" 。

请你返回去重后的收到系统警告的员工名字，将它们按 字典序升序 排序后返回。

请注意 "10:00" - "11:00" 视为一个小时时间范围内，而 "23:51" - "00:10" 不被视为一小时内，因为系统记录的是某一天内的使用情况。

     */
    public static List<String> alertNames(String[] keyName, String[] keyTime) {
        List<String> list = new ArrayList<>();
        HashMap<String, ArrayList<String>> map = new HashMap<>();
        int len = keyName.length;
        for (int i = 0; i < len; i++) {
            if (map.containsKey(keyName[i])) {
                ArrayList<String> timeList = map.get(keyName[i]);
                timeList.add(keyTime[i]);
            } else {
                map.put(keyName[i], new ArrayList<>(Collections.singletonList(keyTime[i])));
            }
        }
        for (String key : map.keySet()) {
            List<String> timeList = map.get(key);
            if (exceedTimesInPeriodWithString(timeList, 3, 60)) {
                list.add(key);
            }
        }
        return list.stream().sorted().collect(Collectors.toList());
    }


    private static boolean exceedTimesInPeriodWithString(List<String> timeList, int count, int period) {
        if (timeList.size() < count) {
            return false;
        }
        List<Integer> sortedTimeList = timeList.stream().sorted()
                .map(e -> {
                    String[] split = e.split(":");
                    return Integer.parseInt(split[0])*60 + Integer.parseInt(split[1]);
                })
                .collect(Collectors.toList());
        for (int i = 0; i < sortedTimeList.size() - count + 1; i++) {
            int between = sortedTimeList.get(i + count - 1) - sortedTimeList.get(i);
            if(between <= period){
                return true;
            }
        }
        return false;
    }

    private static boolean exceedTimesInPeriod(List<String> timeList, int count, long hourPeriod) {
        if (timeList.size() < count) {
            return false;
        }
        List<LocalTime> sortedTimeList = timeList.stream().sorted()
                .map(e -> LocalTime.parse(e, DateTimeFormatter.ofPattern("HH:mm")))
                .collect(Collectors.toList());
        for (int i = 0; i < sortedTimeList.size() - count + 1; i++) {
            Duration between = Duration.between(sortedTimeList.get(i), sortedTimeList.get(i + count - 1));
            if (between.toHours() >= hourPeriod) {
                return true;
            }
        }
        return false;
    }

}

