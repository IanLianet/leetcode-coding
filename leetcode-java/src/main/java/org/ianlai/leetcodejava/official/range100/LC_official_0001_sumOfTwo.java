package org.ianlai.leetcodejava.official.range100;

import org.ianlai.leetcodejava.CryptUtils;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.HashMap;

public class LC_official_0001_sumOfTwo {


    
    public static void main(String[] args) throws NoSuchPaddingException, IOException, NoSuchAlgorithmException, InvalidKeySpecException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        String publicKey =  "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCKMp1pYx9S+3fskzD1nthmUT66sP4g8O++fSfQJJrjqx4BGYyKWAasx/D9MVRmg2bJZy8TWLNimqHK1VxJNyv6uQpUuOeDxOvvaAZYBbbs3bOuVMRI/4WF1zzVaXilN8e06duhRXt2jUd25Gjemw/dAO4ch5LT96cIvVg60DUSnQIDAQAB";
        String privateKey = "MIICdQIBADANBgkqhkiG9w0BAQEFAASCAl8wggJbAgEAAoGBAIoynWljH1L7d+yTMPWe2GZRPrqw" +
                "/iDw7759J9AkmuOrHgEZjIpYBqzH8P0xVGaDZslnLxNYs2KaocrVXEk3K/q5ClS454PE6+9oBlgFtuzds65UxEj/hYXXPNVpeKU3x7Tp26FFe3aNR3bkaN6bD90A7hyHktP3pwi9WDrQNRKdAgMBAAECg" +
                "YB7y5lstWly+WbVGolqDVAGX9MUg8YyFgJ9HjoS3yeMuFWZYJyftPjNwBGljZHwftcNpYvrBbMzq" +
                "hcyzmvr/is7CVthxPVkgI4mWv81iZ9IDqJJbHpm3lJgI4Sv/ioFscwVUu7VrNqgQTwOCdLHZfwX" +
                "xRG055ZfjT28iv6LzWq3dQJBANxk3vD82KsBXEAJHEgxhWKLk26LvyENRXkgkhsfPMWnE8XcXZs2" +
                "JMX2POncbZRKd+pcpUaWV+tZpOUVhuut5SMCQQCghj3hYu7JjAGMq2UaCYY03bQf2y4dGbuLBFsM" +
                "5WBabsajPoV9hUWoGAFHIYSHO7wlyOcaWqo/EDB8gOzwUAU/AkAxiDYWwSzM2gRqm+GQVBjfOfFL" +
                "kfrFqd7oRyqvD8kvvsoR2OHsxTFkkF/GS3URM99Ze7Lld1qRGVeW6Mym4TEzAkA+7eF8ZihuYrCI" +
                "0PhFiM5QE0n14xrk1Z2sFf0LxTBMw3ijrnLujjyMdTyrAfzOdyB/P485yalMJ7CaXoCEhRpJAkAL" +
                "gy/kt94CPjj5EU392L05mOCD3LCqIHAZJ84Jy7vh4E3IeAbYHvPro5HBNnAFdFih0YJV/v6X3sw3+6KhNebR";
        Cipher backDecryptCipher = CryptUtils.newRsaDecrypt(privateKey);
        Cipher backEncryptCipher = CryptUtils.newRsaEncrypt(publicKey);
        System.out.println("*****************");
        String rsaEncryptBase64Encoded = CryptUtils.rsaEncrypt(backEncryptCipher, "123456");
        System.out.println(rsaEncryptBase64Encoded);
        String decrypted = CryptUtils.rsaDecrypt(backDecryptCipher, rsaEncryptBase64Encoded);
        System.out.println(decrypted);
    }

    /**
    * twoSumSolution1 使用快排和头尾双指针向中间逼近的方法，时间复杂度为O(nlogn)+2O(n),空间复杂度为O(n),开销为快排后的有序数组存储
    * @author IanLai
    * @date 2021-11-11 17:27:40
    */
    public static int[] twoSumSolution1(int[] nums, int target) {

        int flag_start = 0;
        int flag_end = nums.length - 1;
        int[] tempNums = nums.clone();

        quickSort(tempNums, flag_start, flag_end);

        while (flag_end > flag_start) {
            if (tempNums[flag_start] + tempNums[flag_end] == target) {
                return findIndices(tempNums[flag_start], tempNums[flag_end], nums);
            } else if (tempNums[flag_start] + tempNums[flag_end] > target) {
                flag_end--;
            } else {
                flag_start++;
            }
        }

        return new int[0];
    }

    private static void quickSort(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }
        int left = start;
        int right = end;
        int temp = nums[left];
        while (left < right) {
            while (left < right && nums[right] >= temp) {
                right--;
            }
            nums[left] = nums[right];
            while (left < right && nums[left] <= temp) {
                left++;
            }
            nums[right] = nums[left];
        }
        nums[left] = temp;
        quickSort(nums, start, left - 1);
        quickSort(nums, left + 1, end);
    }

    private static int[] findIndices(int firstValue, int secondValue, int[] nums) {
        int flag = 0;
        int[] result = new int[]{-1,-1};
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == firstValue && result[0] == -1) {
                result[0] = i;
                flag++;
            } else if (nums[i] == secondValue) {
                result[1] = i;
                flag++;
            }
            if (flag == 2)
                break;
        }
        return result;
    }


    /**
     * twoSumSolution2 HashMap处理，时间复杂度为O(n),空间复杂度为O(n),开销为HashMap的开销
     * @author IanLai
     * @date 2021-11-11 17:27:40
     */
    public static int[] twoSumSolution2(int[] nums, int target) {

        HashMap<Integer,Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++){
            if(hashMap.containsKey(target - nums[i])){
               return new int[]{i, hashMap.get(target - nums[i])};
            }
            hashMap.put(nums[i],i);
        }
        return new int[0];
    }
}

