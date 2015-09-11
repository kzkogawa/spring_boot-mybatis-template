package demo.service.impl;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
		try {
			account.setPassword(encryptPassword(account.getPassword(), account.getId()));
		} catch (NoSuchAlgorithmException e) {
			log.error("", e);
		}
		accountMapper.updateByPrimaryKey(account);
		return insertCount;
	}

	/**
	 * encrypt password using id as a solt
	 * 
	 * @param password
	 * @param id
	 * @return
	 * @throws NoSuchAlgorithmException
	 */
	private String encryptPassword(String password, Integer id) throws NoSuchAlgorithmException {
		MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
		messageDigest.update((password + id).getBytes());
		return Base64.getEncoder().encodeToString(messageDigest.digest());
	}

}
