package mh.lee.luhnTest;
/**
 * 공통된 판별자들에게 사용될 판별자 인터페이스이다.
 * @author 민혁
 * @version 0.0.1
 * */
public interface Validator {
    /**
     * 판별 대상이 될 식별자를 불러들인다.
     * @param sOperand - 입력할 식별자.
     * */
    void setOperand(String sOperand);
    /**
     * Operand를 반환한다.
     * @return return Operand.
     * */
    String getOperand();
    /**
     * 받아들인 식별자가 유효한지 판정한다.
     * */
    void judgeValidity();
    /**
     * 식별후에 결과를 출력한다.
     * @return 식별 판정 여부.
     * */
    boolean isValid();
}
