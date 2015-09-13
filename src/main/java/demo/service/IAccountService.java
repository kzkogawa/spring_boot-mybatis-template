package demo.service;

import demo.model.Account;
import demo.model.AccountSearch;

public interface IAccountService {
	Account findAccount(Integer id);

	Account[] findAccount(AccountSearch searchModel);

	int createAccount(Account account);
}
