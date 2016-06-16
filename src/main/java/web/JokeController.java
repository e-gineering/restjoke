package web;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import domain.ChuckNorrisDatabaseJoke;
import domain.Constants;
import domain.Joke;

/**
 * RestController combines "@Controller and "@ResponseBody Both of these are
 * annotations that make web requests return data instead of a view
 * 
 * the Joke object must be converted to JSON. Thanks to Spring’s HTTP message
 * converter support, I don’t need to do this conversion manually. Because
 * Jackson 2 is on the classpath, Spring’s MappingJackson2HttpMessageConverter
 * is automatically chosen to convert the Greeting instance to JSON."
 */

@RestController
public class JokeController {

	RestTemplate restTemplate = new RestTemplate();

	@RequestMapping(value = "/joke", method = RequestMethod.GET, produces = "application/json")
	public Joke getJoke() {
		Joke myJoke = formatJokeFromCNDB();
		return myJoke;
	}

	// Can the method produce JSON but do so within a ResponseEntity object?
	@RequestMapping(value = "/joke", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<String> postJoke(String token) {
		if (token.equals(Application.expectedToken)) {
			Joke myJoke = formatJokeFromCNDB();
			return new ResponseEntity<String>(myJoke.toString(), HttpStatus.OK);
		} else
			return new ResponseEntity<String>(HttpStatus.UNAUTHORIZED);
	}

	// Rest Template uses Jackson, very convenient, needs its own tests
	private Joke formatJokeFromCNDB() {
		ChuckNorrisDatabaseJoke chuckNorrisDatabaseJoke = restTemplate
				.getForObject(Constants.API_URL, ChuckNorrisDatabaseJoke.class);
		Joke joke = new Joke(chuckNorrisDatabaseJoke.getValue().getJoke());
		return joke;
	}
}