package demo.controller;

import org.junit.Test;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import demo.TestBase;

public class IndexControllerTests extends TestBase {
	@Test
	public void view_demo() throws Exception {
		ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders.get("/demo"));
		resultActions.andExpect(MockMvcResultMatchers.status().isOk());
	}
}
