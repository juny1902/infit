package com.example.ryan.infit;

import java.io.Serializable;
// Activity 간 객체 전달을 위한 Serializable 구현.
public class MBTI implements Serializable {
    private boolean sex;
    private int age;
    private int[] MBTI_Counts;
    private String MBTI_Result_4words;

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public boolean getSex(boolean sex) {
        return sex;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public String getMBTI_Result_4words() {
        return MBTI_Result_4words;
    }

    public int[] getMBTI_Counts() {
        return MBTI_Counts;
    }

    public void setMBTI_Counts(int[] counts) {
        MBTI_Counts = counts;
        findMBTItext();
    }

    static String[] MBTI_Results = {
            "E 에 대한 결과이다.",
            "I 에 대한 결과이다.",
            "S 에 대한 결과이다.",
            "N 에 대한 결과이다.",
            "T 에 대한 결과이다.",
            "F 에 대한 결과이다.",
            "J 에 대한 결과이다.",
            "P 에 대한 결과이다."
    };

    String getMBTI_character_text() {
        switch (MBTI_Result_4words) {
            case "INTJ":
                return "용의주도한 전략가";
            case "INTP":
                return "논리적인 사색가";
            case "ENTJ":
                return "대담한 통솔자";
            case "ENTP":
                return "뜨거운 논쟁을 즐기는 변론가";
            case "INFJ":
                return "선의의 옹호자";
            case "INFP":
                return "열정적인 중재자";
            case "ENFJ":
                return "정의로운 사회운동가";
            case "ENFP":
                return "재기발랄한 활동가";
            case "ISTJ":
                return "청렴결백한 논리주의자";
            case "ISFJ":
                return "용감한 수호자";
            case "ESTJ":
                return "엄격한 관리자";
            case "ESFJ":
                return "사교적인 외교관";
            case "ISTP":
                return "만능 재주꾼";
            case "ISFP":
                return "호기심 많은 예술가";
            case "ESTP":
                return "모험을 즐기는 사업가";
            case "ESFP":
                return "자유로운 영혼의 연예인";
            default:
                return "NULL";
        }
    }

    String getMBTI_character_description() {
        switch (MBTI_Result_4words) {
            case "INTJ":
                return "용의주도한 전략가";
            case "INTP":
                return "논리적인 사색가";
            case "ENTJ":
                return "대담한 통솔자";
            case "ENTP":
                return "뜨거운 논쟁을 즐기는 변론가";
            case "INFJ":
                return "선의의 옹호자";
            case "INFP":
                return "열정적인 중재자";
            case "ENFJ":
                return "정의로운 사회운동가";
            case "ENFP":
                return "재기발랄한 활동가";
            case "ISTJ":
                return "청렴결백한 논리주의자";
            case "ISFJ":
                return "용감한 수호자";
            case "ESTJ":
                return "엄격한 관리자";
            case "ESFJ":
                return "사교적인 외교관";
            case "ISTP":
                return "만능 재주꾼";
            case "ISFP":
                return "호기심 많은 예술가";
            case "ESTP":
                return "모험을 즐기는 사업가";
            case "ESFP":
                return "자유로운 영혼의 연예인";
            default:
                return "NULL";
        }
    }


    public void findMBTItext() {
        String ret = "";
        if (MBTI_Counts[0] > MBTI_Counts[1]) {
            ret = ret + "E";
        } else {
            ret = ret + "I";
        }
        if (MBTI_Counts[2] > MBTI_Counts[3]) {
            ret = ret + "S";
        } else {
            ret = ret + "N";
        }
        if (MBTI_Counts[4] > MBTI_Counts[5]) {
            ret = ret + "T";
        } else {
            ret = ret + "F";
        }
        if (MBTI_Counts[6] > MBTI_Counts[7]) {
            ret = ret + "J";
        } else {
            ret = ret + "P";
        }
        MBTI_Result_4words = ret;
    }


}
