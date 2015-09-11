package demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import demo.model.User;
import demo.service.IUserService;

@RestController
public class UserController {
	private final Logger log = LoggerFactory.getLogger(getClass());
	@Autowired
	IUserService service;

	@RequestMapping(value = { "/user/{id}" }, method = RequestMethod.GET)
	public User get(@PathVariable Integer id) {
		return service.findUser(id);
	}

	@RequestMapping(value = { "/user" }, method = RequestMethod.GET)
	public User[] get(User user) {
		return service.findUser(user);
	}

	@RequestMapping(value = { "/user" }, method = RequestMethod.POST)
	public User post(@RequestBody User user) {
		log.debug("created user {}", service.createUser(user));
		return user;
	}
}
