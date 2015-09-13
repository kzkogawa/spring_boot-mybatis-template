package demo.controller.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import demo.model.Account;
import demo.model.AccountSearch;
import demo.model.RootModel.InsertValidationGroup;
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
	public Account[] get(AccountSearch accountSearch) {
		return service.findAccount(accountSearch);
	}

	@RequestMapping(value = { "/account" }, method = RequestMethod.POST)
	public Account post(@Validated(InsertValidationGroup.class) @RequestBody Account account) {
		log.debug("created account {}", service.createAccount(account));
		return account;
	}
}
