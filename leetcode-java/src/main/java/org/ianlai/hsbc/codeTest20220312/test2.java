package org.ianlai.hsbc.codeTest20220312;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;


/**
 * hsbc test2
 *
 * @author IanLai
 * @date 2022-03-12 17:27:40
 */
public class test2 {

    private static int count = 0;
    private static boolean flag = false;

    public static int strConvert(String str1, String str2) {
        int answer = 0;
        // Write your code here
        loopToConvert(str1, str2, 2);
        return count;
    }

    /**
     * use iteration to get the minimum steps to convert (BFS)
     *
     * @author IanLai
     * @date 2022-03-12 17:45:20
     */
    public static void loopToConvert(String inputString, String targetString, int flipLength) {
        
        if(!flag){
            count = count + 1;
            List<String> changedStringList = new ArrayList<>();
            int tempIndex;
            for (tempIndex = 0; !flag && tempIndex <= targetString.length() - flipLength; tempIndex++) {
                String substring = inputString.substring(tempIndex, tempIndex + flipLength);
                String reversedSubString = new StringBuilder(substring).reverse().toString();
                String outputString = new StringBuilder(inputString)
                        .replace(tempIndex, tempIndex + flipLength, reversedSubString)
                        .toString();
                if (outputString.equals(targetString)) {
                    flag = true;
                    break;
                } else {
                    changedStringList.add(outputString);
                }
            }
            if(!flag){
                for (String inputStringNext : changedStringList) {
                    loopToConvert(inputStringNext, targetString, flipLength + 1);
                }
            }

        }

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);


        int result = strConvert("1010", "0011");
        System.out.print(result);

    }

}

