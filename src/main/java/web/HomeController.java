package web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author Bryson
 * @since 06/06/16 last modified: 06/06/16
 *
 *        RestController combines "@Controller and "@ResponseBody Both of these
 *        are annotations that make web requests return data instead of a view
 * 
 *        serves up home page to client
 */

@Controller
public class HomeController {
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		return "/index.html";
	}
}