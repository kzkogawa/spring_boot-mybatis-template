package demo.service;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import demo.TestBase;
import demo.model.Account;

public class AccountServiceTests extends TestBase {
	@Autowired
	IAccountService accountService;

	@Test
	public void findAccount_1() {
		Account account = accountService.findAccount((Integer) null);
		Assert.assertNull(account);
	}

	@Test
	public void findAccount_2() {
		Account account = accountService.findAccount(1);
		Assert.assertNotNull(account);
	}
}
