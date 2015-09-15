package demo.controller;

import org.junit.Test;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import demo.TestBase;

public class AccountControllerTests extends TestBase {
	@Test
	public void get_account_api() throws Exception {
		ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/account"));
		resultActions.andExpect(MockMvcResultMatchers.status().isOk());
		// resultActions.andExpect(MockMvcResultMatchers.content().string("id"));
	}
}
