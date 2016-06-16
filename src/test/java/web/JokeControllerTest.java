package web;

import static org.junit.Assert.*;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.web.client.RestTemplate;

import domain.ChuckNorrisDatabaseJoke;
import domain.Constants;
import domain.Joke;
import domain.Value;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = MockServletContext.class)
@WebAppConfiguration
public class JokeControllerTest {
	private static final Logger log = Logger
			.getLogger(JokeControllerTest.class);
	private ChuckNorrisDatabaseJoke myDBJoke;
	private Joke myJoke;
	private JokeController jokeController;
	@Mock
	private RestTemplate restTemplate;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		jokeController = new JokeController();
		Application.expectedToken = "testToken";
		ReflectionTestUtils.setField(jokeController, "restTemplate",
				restTemplate);
		Value myValue = new Value();
		myValue.setId((long) 56);
		myValue.setText("This test may pass, but Chuck Norris cannot be tested by conventional means.");
		myDBJoke = new ChuckNorrisDatabaseJoke();
		myDBJoke.setType("success");
		myDBJoke.setValue(myValue);
		myJoke = new Joke(myDBJoke.getValue().getJoke());

	}

	@Test
	public void testGetJoke() throws Exception {
		Mockito.when(
				restTemplate.getForObject(Constants.API_URL,
						ChuckNorrisDatabaseJoke.class)).thenReturn(myDBJoke);
		Joke result = jokeController.getJoke();
		assertEquals(result.getJoke(), myJoke.getJoke());
		log.info("\nJoke object expected:\n " + myJoke);
		log.info("\nJoke object returned:\n " + result);
	}

	@Test
	public void testPostJokeGoodToken() throws Exception {
		Mockito.when(
				restTemplate.getForObject(Constants.API_URL,
						ChuckNorrisDatabaseJoke.class)).thenReturn(myDBJoke);
		ResponseEntity<String> result = jokeController
				.postJoke(Application.expectedToken);
		assertEquals(result, new ResponseEntity<String>(myJoke.toString(),
				HttpStatus.OK));
		log.info("\nJoke object expected for correct token:\n " + myJoke);
		log.info("\nJoke object returned for correct token:\n " + result);
	}

	@Test
	public void testPostJokeBadToken() throws Exception {
			ResponseEntity<String> result = jokeController
					.postJoke("888awfeihfuw");
			assertEquals(result, new ResponseEntity<String>(
					HttpStatus.UNAUTHORIZED));
			log.info("\nJoke object expected for incorrect token:\n <401 Unauthorized,{}> ");
			log.info("\nJoke object returned:\n " + result);
	}
}