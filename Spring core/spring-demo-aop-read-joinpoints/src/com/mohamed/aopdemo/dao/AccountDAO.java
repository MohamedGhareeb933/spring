package com.mohamed.aopdemo.dao;

import org.springframework.stereotype.Component;

import com.mohamed.aopdemo.Account;

@Component
public class AccountDAO {

	public Boolean addAccount(Account account, String name) {
		
		System.out.println( getClass() + " adding " + account.getClass() + " Account to AccountDAO");
		
		return true;
	}
	
	/*public void setName(Account account) {
		account.setName("Mohamed");
	}
	
	public void setLevel(Account account) {
		account.setLevel("senior");
	}*/
}
