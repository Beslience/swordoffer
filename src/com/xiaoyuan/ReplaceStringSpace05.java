/**
 * @Author: zhengjiayuan
 * @Date: 2019/1/4 12:05
 * @Version 1.0
 */
package com.xiaoyuan;


/**
 * 替换空格
 */
public class ReplaceStringSpace05 {

    /**
     * 时间O(n)
     * @param chars
     * @param replace
     * @return
     */
    public static String ReplaceStringSpace(char[] chars, char[] replace){
        if (chars.length == 0 ) return "";
        int spaceCount = 0;
        for(int i = 0; i < chars.length; i++){
            if (chars[i] == ' ')
                spaceCount++;
        }
        if (spaceCount == 0)
            return new String(chars);
        int oldlength = chars.length;
        int newlength = chars.length + replace.length * spaceCount - spaceCount;
        // ------------模仿出c++,不用借助额外辅助空间-----------//
        char[] newchars = new char[newlength];
        for(int i = 0; i < chars.length; i++){
            newchars[i] = chars[i];
        }
        // ------------模仿出c++-----------//

        for (int i = oldlength - 1, j = newlength; i >= 0 && j >= 0; i--){
            if (newchars[i] != ' ')
                newchars[--j] = newchars[i];
            else{
                j -= replace.length;
                for (int k = 0; k < replace.length;k++)
                    newchars[k + j] = replace[k];
            }
        }

        return new String(newchars);
    }

    public static void main(String[] args) {
        System.out.println(ReplaceStringSpace("We are happy".toCharArray(), "%20".toCharArray()));
        System.out.println(ReplaceStringSpace(" We are happy ".toCharArray(), "%20".toCharArray()));
        System.out.println(ReplaceStringSpace("Wearehappy".toCharArray(), "%20".toCharArray()));
        System.out.println(ReplaceStringSpace("".toCharArray(), "%20".toCharArray()));
    }
}
