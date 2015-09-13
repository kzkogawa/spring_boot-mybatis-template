package demo.controller.view;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
	@RequestMapping({ "/demo" })
	public String index(Model model) {
		return "demo";
	}
}
