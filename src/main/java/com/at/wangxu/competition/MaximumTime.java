package com.at.wangxu.competition;

public class MaximumTime {

    public String maximumTime(String time) {
        //00:00 - 23:59
        StringBuilder stringBuilder = new StringBuilder();
        char[] chars = time.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '?') {
                if (i == 0) {
                    if (chars[1] == '?') {
                        stringBuilder.append("23");
                        i ++;
                    }else {
                        if (chars[1] > '3') {
                            stringBuilder.append('1');
                        }else {
                            stringBuilder.append('2');
                        }
                    }
                }else if (i == 1) {
                    if (chars[0] == '2') {
                        stringBuilder.append('3');
                    }else {
                        stringBuilder.append('9');
                    }
                }else if (i == 2) {

                }else if (i  == 3) {
                    if (chars[4] == '?') {
                        stringBuilder.append("59");
                        i ++;
                    }else {
                        stringBuilder.append('5');
                    }
                }else if (i == 4) {
                    stringBuilder.append('9');
                }
            }else {
                stringBuilder.append(chars[i]);
            }
        }

        return stringBuilder.toString();
    }
}
