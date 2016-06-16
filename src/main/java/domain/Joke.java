package domain;

public class Joke {
	private String joke;
	
	public Joke(String joke) {
		this.joke = joke;
	}
	
	public String getJoke() {
		return this.joke;
	}
	@Override
	public String toString() {
		return "{\n\"text\": \"" + this.getJoke() + "\"\n}";
		}
}
