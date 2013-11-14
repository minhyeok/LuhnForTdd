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
	private String sOperand;
	/**
	 * 결과와 확인할 식별자이다.
	 * */
	private int iValidator;
	/**
	 * 추후 유효성 여부를 판단하고자 사용한다.
	 * */
	private boolean isValid = false;
	/**나누어질 수 10을 명시함.*/
	public static final int DIGIT_TEN = 10;
	/**
     * Operand를 정한다.
     * @param operand get String to judge validity.
     * @param validator 후에 일치 여부를 확인할 인자.
     * */
    public final void setOperand(final String operand, final int validator) {
        this.setOperand(operand);
        iValidator = validator;
	}
    /**
     * Operand를 정한다.
     * @param operand get String to judge validity.
     * */
    public final void setOperand(final String operand) {
        this.sOperand = operand;
    }
    /**
     * Operand를 반환한다.
     * @return return Operand.
     * */
    public final String getOperand() {
        return sOperand;
    }
	/**
	 * 해당 오퍼랜드의 유효성 여부를 판단 한 후 값을 넘겨준다.
	 * */
	public final void judgeValidity() {
		int score;
		score = judgeValidityIterative();
		if (score % DIGIT_TEN == iValidator) {
			isValid = true;
		}
	}
//	/**
//	 * 해당 Digit의 결과를 Recursive하게 탐색하여 결과를 도출한다.
//	 * @param isOdd 자릿수가 짝수 홀수를 판단하는 것 처음엔 false.
//	 * @return 해당 행의 점수를 도출한다.
//	 * */
//	private int judgeValidityRecursive(final int iOperand,
//	        final boolean isOdd) {
//		int iScore = 0;
//		iScore = iOperand % DIGIT_TEN;
//		/**글로벌 오퍼랜드를 쓰는게 나을까,
//		 * 로컬 배리어블을 갖는게 나을까*/
//		if (!isOdd) {
//		    /** 짝수 일때만 수행한다. */
//			iScore = getEvenScore(iScore);
//		}
//		/**다음 자릿수 탐색한다.*/
//		iOperand /= DIGIT_TEN;
//		if (iOperand != 0) {
//			return iScore + judgeValidityRecursive(!isOdd);
//		} else {
//			return iScore;
//		}
//	}
	/**해당 Digit의 결과를 Iterative하게 탐색하여 결과를 도출한다.
	 * @return Operand의 Valid 계산 결과를 도출한다.
	 *  */
	private int judgeValidityIterative() {
	    int score = 0;
	    /**홀수 자리부를 더한다.*/
	    for (int index = sOperand.length() - 1; index >= 0; index -= 2) {
	        score += charToInteger(index);
	    }
	    /**짝수 자리부를 처리한다.*/
	    for (int index = sOperand.length() - 2; index >= 0; index -= 2) {
	        score += getEvenScore(charToInteger(index));
	    }
	    return score;
	}
    /**
     * @param index Operand의 해당위치 글자를 숫자로 변환한다.
     * @return int형으로 변환된 글자 값
     */
    public final int charToInteger(final int index) {
        int iDigit = Character.digit(sOperand.charAt(index), DIGIT_TEN);
        return iDigit;
    }
	/**
	 * 해당 자릿수를 2배수 하여 두 자리를 더한 값을 반환한다.
	 * @param iScore 대상이 되는 자릿수.
	 * @return 두 자리를 더한 값.
	 * */
	private int getEvenScore(final int iScore) {
		return iScore * 2 / DIGIT_TEN + iScore * 2 % DIGIT_TEN;
	}
	/**
	 * 유효한지 여부를 판별하는 메서드.
	 * @return 판정 후 유효한 값인지 아닌지 반환한다.
	 * */
	public final boolean isValid() {
		return isValid;
	}
}
