package demo.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import demo.mapper.AccountMapper;
import demo.model.Account;
import demo.model.RootSearchModel;
import demo.service.IAccountService;

@Service
public class AccountServiceImpl implements IAccountService {
	private final Logger log = LoggerFactory.getLogger(getClass());
	@Autowired
	AccountMapper accountMapper;
	@Autowired
	PasswordEncoder passwordEncoder;

	@Override
	public Account findAccount(Integer id) {
		return accountMapper.selectByPrimaryKey(id);
	}

	@Override
	public Account[] findAccount(Account account) {
		return accountMapper.selectList(account, new RootSearchModel().getRowBounds());
	}

	@Transactional
	@Override
	public int createAccount(Account account) {
		int insertCount = accountMapper.insert(account);
		account.setPassword(passwordEncoder.encode(account.getPassword()));
		accountMapper.updateByPrimaryKey(account);
		return insertCount;
	}
}
