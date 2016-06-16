package domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * annotation from the Jackson JSON processing library to indicate that any
 * properties not bound in this type should be ignored
 * (https://spring.io/guides/gs/consuming-rest/)
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ChuckNorrisDatabaseJoke {
	// type will be “success” on success and something else when something went
	// wrong
	private String type;
	private Value value;

	public ChuckNorrisDatabaseJoke() {
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Value getValue() {
		return value;
	}

	public void setValue(Value value) {
		this.value = value;
	}

	// from https://spring.io/guides/gs/consuming-rest/
	@Override
	public String toString() {
		return "Joke{" + "type='" + type + '\'' + ", value=" + value + '}';
	}

}
