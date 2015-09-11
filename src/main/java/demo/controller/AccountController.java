package demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import demo.model.Account;
import demo.service.IAccountService;

@RestController
public class AccountController {
	private final Logger log = LoggerFactory.getLogger(getClass());
	@Autowired
	IAccountService service;

	@RequestMapping(value = { "/account/{id}" }, method = RequestMethod.GET)
	public Account get(@PathVariable Integer id) {
		return service.findAccount(id);
	}

	@RequestMapping(value = { "/account" }, method = RequestMethod.GET)
	public Account[] get(Account account) {
		return service.findAccount(account);
	}

	@RequestMapping(value = { "/account" }, method = RequestMethod.POST)
	public Account post(@RequestBody Account account) {
		log.debug("created account {}", service.createAccount(account));
		return account;
	}
}
