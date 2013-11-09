package mh.lee.luhnTest;
/**
 * This is Class For Luhn Algorithm Test.
 * @author ����
 * @version 0.01
 * */
public class CardValidator {
	private int iOperand;
	private int iLength;
	private boolean isValid = false;
	/**
	 * @param sOperand : get String to judge validity.
	 * TODO : ����ó���� �ʿ��ϴ�
	 * */
	public void setOperand(final String sOperand){
		iLength = sOperand.length();
		iOperand = Integer.valueOf(sOperand);
	}
	/**
	 * �ش� ���۷����� ��ȿ�� ���θ� �Ǵ� �� �� ���� �Ѱ��ش�.
	 * */
	public void judgeValidity(){
		int score;
		score = judgeValidityRecursive(true);
		if(score % 10 == 0){
			isValid = true;
		}
	}
	/**
	 * ���� ����� �ϴ� �Լ��̳�, �ش� Digit�� ����� Recursive�ϰ� Ž���Ͽ� ����� �����Ѵ�.
	 * @param isOdd �ڸ����� ¦�� Ȧ���� �Ǵ��ϴ� �� ó���� false.
	 * @return �ش� ���� ������ �����Ѵ�.
	 * */
	private int judgeValidityRecursive(boolean isOdd){
		int iScore = 0;
		iScore = iOperand % 10;
		if(!isOdd){ /**¦�� �϶��� ����*/
			iScore = getEvenScore(iScore);
		}
		iOperand /= 10;
		if(iOperand != 0){
			return iScore + judgeValidityRecursive(!isOdd);
		}else{
			return iScore;
		}
	}
	private int getEvenScore(int iScore) {
		iScore *= 2;
		return (iScore/10) + (iScore%10);
	}
	/**
	 * ��ȿ���� ���θ� �Ǻ��ϴ� �޼���.
	 * @return ���� �� ��ȿ�� ������ �ƴ��� ��ȯ�Ѵ�.
	 * */
	public boolean isValid(){
		return isValid;
	}
}
