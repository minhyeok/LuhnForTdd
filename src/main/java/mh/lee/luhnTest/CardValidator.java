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
	private int iOperand;
	/**
	 * ���� ��ȿ�� ���θ� �Ǵ��ϰ��� ����Ѵ�.
	 * */
	private boolean isValid = false;
	/**�������� �� 10�� �����.*/
	public static final int JUDGE_TEN = 10;
	/**
	 * @param sOperand : get String to judge validity.
	 * TODO : �߸��� ���� ����ó���� �ʿ��ϴ�.
	 * */
	public final void setOperand(final String sOperand) {
		iOperand = Integer.valueOf(sOperand);
	}
	/**
	 * �ش� ���۷����� ��ȿ�� ���θ� �Ǵ� �� �� ���� �Ѱ��ش�.
	 * */
	public final void judgeValidity() {
		int score;
		score = judgeValidityRecursive(true);
		if (score % JUDGE_TEN == 0) {
			isValid = true;
		}
	}
	/**
	 * ���� ����� �ϴ� �Լ��̳�, �ش� Digit�� ����� Recursive�ϰ� Ž���Ͽ� ����� �����Ѵ�.
	 * @param isOdd �ڸ����� ¦�� Ȧ���� �Ǵ��ϴ� �� ó���� false.
	 * @return �ش� ���� ������ �����Ѵ�.
	 * */
	private int judgeValidityRecursive(final boolean isOdd) {
		int iScore = 0;
		iScore = iOperand % JUDGE_TEN;
		if (!isOdd) {
		    /** ¦�� �϶��� �����Ѵ�. */
			iScore = getEvenScore(iScore);
		}
		/**���� �ڸ��� Ž���Ѵ�.*/
		iOperand /= JUDGE_TEN;
		if (iOperand != 0) {
			return iScore + judgeValidityRecursive(!isOdd);
		} else {
			return iScore;
		}
	}
	/**
	 * �ش� �ڸ����� 2��� �Ͽ� �� �ڸ��� ���� ���� ��ȯ�Ѵ�.
	 * @param iScore ����� �Ǵ� �ڸ���.
	 * @return �� �ڸ��� ���� ��.
	 * */
	private int getEvenScore(int iScore) {
		iScore *= 2;
		return iScore / JUDGE_TEN + iScore % JUDGE_TEN;
	}
	/**
	 * ��ȿ���� ���θ� �Ǻ��ϴ� �޼���.
	 * @return ���� �� ��ȿ�� ������ �ƴ��� ��ȯ�Ѵ�.
	 * */
	public final boolean isValid() {
		return isValid;
	}
}
