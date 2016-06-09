package web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import domain.Joke;
import domain.ChuckNorrisDatabaseJoke;

/**
 * @author Bryson
 * @since 05/24/16 date last modified 06/0116
 *
 *        RestController combines "@Controller and "@ResponseBody Both of these
 *        are annotations that make web requests return data instead of a view
 */

@RestController
public class JokeController {
	public static final String API_URL = "https://api.icndb.com/jokes/random?exclude=[explicit]";

	RestTemplate restTemplate = new RestTemplate();

	@RequestMapping(value = "/joke", produces = "application/json")
	public Joke getJoke() {
		/**
		 * the Joke object must be converted to JSON. Thanks to
		 * Spring’s HTTP message converter support, I don’t need to do this
		 * conversion manually. Because Jackson 2 is on the classpath, Spring’s
		 * MappingJackson2HttpMessageConverter is automatically chosen to
		 * convert the Greeting instance to JSON."
		 */

		// Rest Template uses Jackson, very convenient, needs its own tests
		ChuckNorrisDatabaseJoke chuckNorrisDatabaseJoke = restTemplate.getForObject(API_URL, ChuckNorrisDatabaseJoke.class);
		Joke myJoke = new Joke(chuckNorrisDatabaseJoke.getValue().getJoke());
		return myJoke;
	}
}