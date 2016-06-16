package domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Class needed to embed the inner contents of the joke itself
 * (https://spring.io/guides/gs/consuming-rest/)
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Value {
	private long id;
	private String joke;

	public Value() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getJoke() {
		return this.joke;
	}

	public void setText(String joke) {
		this.joke = joke;
	}

	// from https://spring.io/guides/gs/consuming-rest/
	@Override
	public String toString() {
		return "Value{" + "id='" + id + '\'' + ", joke=" + this.joke + '}';
	}

}
