package mh.lee.luhnTest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class LuhnTest {
	
	CardValidator validator;
	@Before
	public void setUp() throws Exception{
		validator = new CardValidator();
	}
	@Test
	public void firstTest(){
		validator.setOperand("446667651");
		validator.judgeValidity();
		assertTrue(validator.isValid());
	}
	
	@Test
	public void zeroTest(){
		validator.setOperand("0000000000");
		validator.judgeValidity();
		assertTrue(validator.isValid());
	}
	
	@Test
	public void invalidLongTest(){
	    validator.setOperand("38281732");
	    validator.judgeValidity();
	    assertTrue(validator.isValid());
	}
	
	@Test
	public void singleCharacterTest(){
		validator.setOperand("0");
		validator.judgeValidity();
		assertTrue(validator.isValid());
	}
	
	@Test
	public void invalidSingleCharacterTest(){
	    validator.setOperand("4");
	    validator.judgeValidity();
	    assertTrue(validator.isValid());
	}
	
	@Test
	public void wrongCharacterTest(){
		validator.setOperand("---");
		validator.judgeValidity();
	}

}
