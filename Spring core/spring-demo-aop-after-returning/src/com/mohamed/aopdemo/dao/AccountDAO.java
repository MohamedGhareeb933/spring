package com.mohamed.aopdemo.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.mohamed.aopdemo.Account;

@Component
public class AccountDAO {
	
	public List<Account> findAccount() {
		List<Account> account = new ArrayList<>();
		
		account.add(new Account("Asser", "Junior"));
		account.add(new Account("Mostafa", "senior"));
		account.add(new Account("Ayten", "Junior"));

		return account;
	}

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
