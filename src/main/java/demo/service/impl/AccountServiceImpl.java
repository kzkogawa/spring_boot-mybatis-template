package demo.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import demo.mapper.AccountMapper;
import demo.mapper.AccountRoleMapper;
import demo.model.Account;
import demo.model.AccountRole;
import demo.model.SearchModel;
import demo.service.IAccountService;

@Service
public class AccountServiceImpl implements IAccountService {
	private final Logger log = LoggerFactory.getLogger(getClass());
	@Autowired
	AccountMapper accountMapper;
	@Autowired
	AccountRoleMapper accountRoleMapper;
	@Autowired
	PasswordEncoder passwordEncoder;

	@Override
	public Account findAccount(Integer id) {
		return accountMapper.selectByPrimaryKey(id);
	}

	@Override
	public Account[] findAccount(SearchModel searchModel) {
		return accountMapper.selectList(searchModel.getQuery(), searchModel.getRowBounds());
	}

	@Transactional
	@Override
	public int createAccount(Account account) {
		int insertCount = accountMapper.insert(account);
		account.setPassword(passwordEncoder.encode(account.getPassword()));
		accountMapper.updateByPrimaryKey(account);
		if (account.getAccountRoles() != null)
			for (AccountRole accountRole : account.getAccountRoles()) {
				accountRole.setUserName(account.getUserName());
				accountRoleMapper.insert(accountRole);
			}
		return insertCount;
	}
}
