package mh.lee.luhnTest;
/**
 * This is Class For Luhn Algorithm Test.
 * @author 민혁
 * @version 0.01
 * */
public class CardValidator implements Validator {
    /**
	 * 입력받을 수의 변수공간이다.
	 * */
	private int iOperand;
	/**
	 * 추후 유효성 여부를 판단하고자 사용한다.
	 * */
	private boolean isValid = false;
	/**나누어질 수 10을 명시함.*/
	public static final int JUDGE_TEN = 10;
	/**
	 * @param sOperand : get String to judge validity.
	 * TODO : 잘못된 글자 예외처리가 필요하다.
	 * */
	public final void setOperand(final String sOperand) {
		iOperand = Integer.valueOf(sOperand);
	}
	/**
	 * 해당 오퍼랜드의 유효성 여부를 판단 한 후 값을 넘겨준다.
	 * */
	public final void judgeValidity() {
		int score;
		score = judgeValidityRecursive(true);
		if (score % JUDGE_TEN == 0) {
			isValid = true;
		}
	}
	/**
	 * 동일 기능을 하는 함수이나, 해당 Digit의 결과를 Recursive하게 탐색하여 결과를 도출한다.
	 * @param isOdd 자릿수가 짝수 홀수를 판단하는 것 처음엔 false.
	 * @return 해당 행의 점수를 도출한다.
	 * */
	private int judgeValidityRecursive(final boolean isOdd) {
		int iScore = 0;
		iScore = iOperand % JUDGE_TEN;
		if (!isOdd) {
		    /** 짝수 일때만 수행한다. */
			iScore = getEvenScore(iScore);
		}
		/**다음 자릿수 탐색한다.*/
		iOperand /= JUDGE_TEN;
		if (iOperand != 0) {
			return iScore + judgeValidityRecursive(!isOdd);
		} else {
			return iScore;
		}
	}
	/**
	 * 해당 자릿수를 2배수 하여 두 자리를 더한 값을 반환한다.
	 * @param iScore 대상이 되는 자릿수.
	 * @return 두 자리를 더한 값.
	 * */
	private int getEvenScore(int iScore) {
		iScore *= 2;
		return iScore / JUDGE_TEN + iScore % JUDGE_TEN;
	}
	/**
	 * 유효한지 여부를 판별하는 메서드.
	 * @return 판정 후 유효한 값인지 아닌지 반환한다.
	 * */
	public final boolean isValid() {
		return isValid;
	}
}
