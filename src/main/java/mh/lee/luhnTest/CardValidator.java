package mh.lee.luhnTest;
/**
 * This is Class For Luhn Algorithm Test.
 * @author ����
 * @version 0.01
 * */
public class CardValidator implements Validator {
    /**
	 * �Է¹��� ���� ���������̴�.
	 * */
	private String sOperand;
	/**
	 * ����� Ȯ���� �ĺ����̴�.
	 * */
	private int iValidator;
	/**
	 * ���� ��ȿ�� ���θ� �Ǵ��ϰ��� ����Ѵ�.
	 * */
	private boolean isValid = false;
	/**�������� �� 10�� �����.*/
	public static final int DIGIT_TEN = 10;
	/**
     * Operand�� ���Ѵ�.
     * @param operand get String to judge validity.
     * @param validator �Ŀ� ��ġ ���θ� Ȯ���� ����.
     * */
    public final void setOperand(final String operand, final int validator) {
        this.setOperand(operand);
        iValidator = validator;
	}
    /**
     * Operand�� ���Ѵ�.
     * @param operand get String to judge validity.
     * */
    public final void setOperand(final String operand) {
        this.sOperand = operand;
    }
    /**
     * Operand�� ��ȯ�Ѵ�.
     * @return return Operand.
     * */
    public final String getOperand() {
        return sOperand;
    }
	/**
	 * �ش� ���۷����� ��ȿ�� ���θ� �Ǵ� �� �� ���� �Ѱ��ش�.
	 * */
	public final void judgeValidity() {
		int score;
		score = judgeValidityIterative();
		if (score % DIGIT_TEN == iValidator) {
			isValid = true;
		}
	}
//	/**
//	 * �ش� Digit�� ����� Recursive�ϰ� Ž���Ͽ� ����� �����Ѵ�.
//	 * @param isOdd �ڸ����� ¦�� Ȧ���� �Ǵ��ϴ� �� ó���� false.
//	 * @return �ش� ���� ������ �����Ѵ�.
//	 * */
//	private int judgeValidityRecursive(final int iOperand,
//	        final boolean isOdd) {
//		int iScore = 0;
//		iScore = iOperand % DIGIT_TEN;
//		/**�۷ι� ���۷��带 ���°� ������,
//		 * ���� �踮����� ���°� ������*/
//		if (!isOdd) {
//		    /** ¦�� �϶��� �����Ѵ�. */
//			iScore = getEvenScore(iScore);
//		}
//		/**���� �ڸ��� Ž���Ѵ�.*/
//		iOperand /= DIGIT_TEN;
//		if (iOperand != 0) {
//			return iScore + judgeValidityRecursive(!isOdd);
//		} else {
//			return iScore;
//		}
//	}
	/**�ش� Digit�� ����� Iterative�ϰ� Ž���Ͽ� ����� �����Ѵ�.
	 * @return Operand�� Valid ��� ����� �����Ѵ�.
	 *  */
	private int judgeValidityIterative() {
	    int score = 0;
	    /**Ȧ�� �ڸ��θ� ���Ѵ�.*/
	    for (int index = sOperand.length() - 1; index >= 0; index -= 2) {
	        score += charToInteger(index);
	    }
	    /**¦�� �ڸ��θ� ó���Ѵ�.*/
	    for (int index = sOperand.length() - 2; index >= 0; index -= 2) {
	        score += getEvenScore(charToInteger(index));
	    }
	    return score;
	}
    /**
     * @param index Operand�� �ش���ġ ���ڸ� ���ڷ� ��ȯ�Ѵ�.
     * @return int������ ��ȯ�� ���� ��
     */
    public final int charToInteger(final int index) {
        int iDigit = Character.digit(sOperand.charAt(index), DIGIT_TEN);
        return iDigit;
    }
	/**
	 * �ش� �ڸ����� 2��� �Ͽ� �� �ڸ��� ���� ���� ��ȯ�Ѵ�.
	 * @param iScore ����� �Ǵ� �ڸ���.
	 * @return �� �ڸ��� ���� ��.
	 * */
	private int getEvenScore(final int iScore) {
		return iScore * 2 / DIGIT_TEN + iScore * 2 % DIGIT_TEN;
	}
	/**
	 * ��ȿ���� ���θ� �Ǻ��ϴ� �޼���.
	 * @return ���� �� ��ȿ�� ������ �ƴ��� ��ȯ�Ѵ�.
	 * */
	public final boolean isValid() {
		return isValid;
	}
}
