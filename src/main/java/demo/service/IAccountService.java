package demo.service;

import demo.model.Account;

public interface IAccountService {
	Account findAccount(Integer id);

	Account[] findAccount(Account account);

	int createAccount(Account account);
}
