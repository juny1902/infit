package com.brainyoung.ryan.arabang;

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
            "  폭넓은 대인관계를 유지하고, 사교적이며 정열적이고 활동적입니다.",
            "  깊이 있는 대인관계를 유지하고, 조용하고 신중합니다.",
            "  오감에 의존하여 실제의 경험을 중시하며 지금, 현재에 초점을 맞추고 정확하고 철저히 일을 처리합니다.",
            "  육감 내지 영감에 의존하여 미래지향적이고 가능성과 의미를 추구하며 신속, 비약적으로 일처리 합니다.",
            "  진실과 사실에 주관심을 갖고 논리적이고 분석적이며 객관적으로 판단합니다.",
            "  사람과 관계에 주관심을 갖고 상황적이며 정상을 참작한 설명을 합니다.",
            "  목적과 방향이 있으며 기한을 엄수하고 철저히 사전계획을 하며 체계적입니다.",
            "  목적과 방향은 변화 가능하고 상황에 따라 일정이 달라지며, 자율적이고 융통성이 있습니다.   "
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
                return "  전체적인 부분을 조합하여\n비전을 제시하는 사람이군요!";
            case "INTP":
                return "  비전적인 관점을 가지고 있는\n뛰어난 전략가군요!";
            case "ENTJ":
                return "  비전을 가지고 사람들을\n활력적으로 이끌어가는 사람이군요!";
            case "ENTP":
                return "  풍부한 상상력을 가지고\n새로운 것에 도전하는 사람이군요!";
            case "INFJ":
                return "  사람과 관련된 뛰어난 통찰력을\n가지고 있는 사람이군요!";
            case "INFP":
                return "  이상적인 세상을\n만들어가는 사람이군요!";
            case "ENFJ":
                return "  타인의 성장을 도모하고\n협동하는 사람이군요!";
            case "ENFP":
                return "  열정적으로 새로운\n관계를 만드는 사람이군요!";
            case "ISTJ":
                return "  한 번 시작한 일을\n끝까지 해내는 사람이군요!";
            case "ISFJ":
                return "  성실하고 온화하며\n협조를 잘하는 사람이군요!";
            case "ESTJ":
                return "  사무적, 실용적, 현실적으로\n일을 많이 하는 사람이군요!";
            case "ESFJ":
                return "  친절과 현실감을 바탕으로 타인에게 봉사하는 사람이군요!";
            case "ISTP":
                return "  논리적이고 뛰어난 상황 적응력을 가지고 있는 사람이군요!";
            case "ISFP":
                return "  따뜻한 감정을 가지고 있는 겸손한 사람이군요!";
            case "ESTP":
                return "  친구, 운동, 음식 등 다양한 활동을 선호하는 사람이군요!";
            case "ESFP":
                return "  분위기를 고조시키는 우호적 사람이군요!";
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
