package demo.service;

import demo.model.Account;
import demo.model.SearchModel;

public interface IAccountService {
	Account findAccount(Integer id);

	Account[] findAccount(SearchModel searchModel);

	int createAccount(Account account);
}
