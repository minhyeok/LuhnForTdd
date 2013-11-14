package mh.lee.luhnTest;
/**
 * ����� �Ǻ��ڵ鿡�� ���� �Ǻ��� �������̽��̴�.
 * @author ����
 * @version 0.0.1
 * */
public interface Validator {
    /**
     * �Ǻ� ����� �� �ĺ��ڸ� �ҷ����δ�.
     * @param sOperand - �Է��� �ĺ���.
     * */
    void setOperand(String sOperand);
    /**
     * Operand�� ��ȯ�Ѵ�.
     * @return return Operand.
     * */
    String getOperand();
    /**
     * �޾Ƶ��� �ĺ��ڰ� ��ȿ���� �����Ѵ�.
     * */
    void judgeValidity();
    /**
     * �ĺ��Ŀ� ����� ����Ѵ�.
     * @return �ĺ� ���� ����.
     * */
    boolean isValid();
}
