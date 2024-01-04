package com.ares.infrastructure.algo.string;

/**
 * 检查String之间是否彼此旋转 eg：如果s1 =“IndiaUSAEngland”并且s2 =“USAEnglandIndia”那么你的程序应该返回true但是如果s2
 * =“IndiaEnglandUSA”那么它应该返回false
 *
 * @author 0xZzzz
 */
public class StringRotationExample {

    public static void main(String[] args) {
        System.out.println(checkRotation("IndiaUSAEngland", "USAEnglandIndia"));
        System.out.println(checkRotation("IndiaUSAEngland", "IndiaEnglandUSA"));
    }

    public static boolean checkRotation(String original, String rotation) {
        return original.length() == rotation.length() && (original + original).contains(rotation);
    }

}
