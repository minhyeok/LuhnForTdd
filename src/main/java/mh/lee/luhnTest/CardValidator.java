package mh.lee.luhnTest;
/**
 * This is Class For Luhn Algorithm Test.
 * @author 민혁
 * @version 0.01
 * */
public class CardValidator {
	private int iOperand;
	private int iLength;
	private boolean isValid = false;
	/**
	 * @param sOperand : get String to judge validity.
	 * TODO : 예외처리가 필요하다
	 * */
	public void setOperand(final String sOperand){
		iLength = sOperand.length();
		iOperand = Integer.valueOf(sOperand);
	}
	/**
	 * 해당 오퍼랜드의 유효성 여부를 판단 한 후 값을 넘겨준다.
	 * */
	public void judgeValidity(){
		int score;
		score = judgeValidityRecursive(true);
		if(score % 10 == 0){
			isValid = true;
		}
	}
	/**
	 * 동일 기능을 하는 함수이나, 해당 Digit의 결과를 Recursive하게 탐색하여 결과를 도출한다.
	 * @param isOdd 자릿수가 짝수 홀수를 판단하는 것 처음엔 false.
	 * @return 해당 행의 점수를 도출한다.
	 * */
	private int judgeValidityRecursive(boolean isOdd){
		int iScore = 0;
		iScore = iOperand % 10;
		if(!isOdd){ /**짝수 일때만 수행*/
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
	 * 유효한지 여부를 판별하는 메서드.
	 * @return 판정 후 유효한 값인지 아닌지 반환한다.
	 * */
	public boolean isValid(){
		return isValid;
	}
}
