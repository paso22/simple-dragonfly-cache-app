package ge.paso22.simpledragonflycacheapp.model;

public class DictionaryResponse {
  private String word;
  private String definition;
  private boolean cached;

  public DictionaryResponse() {}

  public DictionaryResponse(String word, String definition, boolean cached) {
    this.word = word;
    this.definition = definition;
    this.cached = cached;
  }

  public String getWord() {
    return word;
  }

  public void setWord(String word) {
    this.word = word;
  }

  public String getDefinition() {
    return definition;
  }

  public void setDefinition(String definition) {
    this.definition = definition;
  }

  public boolean isCached() {
    return cached;
  }

  public void setCached(boolean cached) {
    this.cached = cached;
  }
}
