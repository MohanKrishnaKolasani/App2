package com.example.app2;

public class Question {

    String question, crtOption;
    String op1, op2, op3, op4;

    public Question(String question, String crtOption, String op1, String op2, String op3, String op4) {
        this.question = question;
        this.crtOption = crtOption;
        this.op1 = op1;
        this.op2 = op2;
        this.op3 = op3;
        this.op4 = op4;
    }

    public String getQuestion() {
        return question;
    }

    public String getCrtOption() {
        return crtOption;
    }

    public String getOp1() {
        return op1;
    }

    public String getOp2() {
        return op2;
    }

    public String getOp3() {
        return op3;
    }

    public String getOp4() {
        return op4;
    }
}