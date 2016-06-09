package web;

import static org.junit.Assert.assertEquals;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.web.client.RestTemplate;

import domain.Joke;
import domain.ChuckNorrisDatabaseJoke;
import domain.Value;

/**
 * 
 * @author Bryson
 * @since 05/24/16 date last modified 06/01/16
 *
 */

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
		ReflectionTestUtils.setField(jokeController, "restTemplate",
				restTemplate);
		Value myValue = new Value();
		myValue.setId((long) 56);
		myValue.setJoke("This test may pass, but Chuck Norris cannot be tested by conventional means.");
		myDBJoke = new ChuckNorrisDatabaseJoke();
		myDBJoke.setType("success");
		myDBJoke.setValue(myValue);
		myJoke = new Joke(myDBJoke.getValue().getJoke());

	}

	@Test
	public void testGetJoke() throws Exception {
		Mockito.when(
				restTemplate
						.getForObject(
								"https://api.icndb.com/jokes/random?exclude=[explicit]",
								ChuckNorrisDatabaseJoke.class)).thenReturn(myDBJoke);
		Joke result = jokeController.getJoke();
		assertEquals(result.getContents(), myDBJoke.getValue().getJoke());
		log.info("Joke object expected: " + myJoke);
		log.info("Joke object returned: " + result);
		log.info("Joke Controller Test Passed");
	}
}