package edu.elon.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ATMTest {
	
	private ATM atm;

	@Before
	public void setUp() throws Exception {
		 atm = new ATM(1000);
	}

	@After
	public void tearDown() throws Exception {
		atm = null;
	}

	@Test (expected = IllegalArgumentException.class)
	public void testDeposit() {
		double amount = -1;
		atm.deposit(amount);
	}
	
	public void testDepositAgain() {
		double amount = 100;
		atm.deposit(amount);
		double expected = 1100;
		double actual = atm.getBalance();
		assertEquals(expected, actual, 0);
	}

	@Test
	public void testGetBalance() {
		double expected = 1000;
		double actual = atm.getBalance();
		assertEquals(expected,actual, 0);
	}

	@Test (expected = IllegalArgumentException.class)
	public void testWithdraw() {
		double amount = -1;
		atm.deposit(amount);
		
	}
	
	public void testWithdrawAgain() {
		double amount = 100;
		atm.withdraw(amount);
		double expected = 900;
		double actual = atm.getBalance();
		assertEquals(expected, actual, 0);
		
	}

}
