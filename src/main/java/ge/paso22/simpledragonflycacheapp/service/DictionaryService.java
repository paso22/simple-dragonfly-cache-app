package ge.paso22.simpledragonflycacheapp.service;

import ge.paso22.simpledragonflycacheapp.model.DictionaryResponse;
import ge.paso22.simpledragonflycacheapp.repository.DictionaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Service;

@Service
public class DictionaryService {

  @Autowired private DictionaryRepository dictionaryRepository;

  @Autowired private CacheManager cacheManager;

  public DictionaryResponse getDefinitionWithCacheInfo(String word) {
    String cacheKey = word.toLowerCase();
    Cache cache = cacheManager.getCache("dictionaryCache");
    boolean cached = false;
    String definition = null;

    if (cache != null && cache.get(cacheKey) != null) {
      definition = (String) cache.get(cacheKey).get();
      cached = true;
    } else {
      // Cache miss: read from database, and then cache the record
      definition =
          dictionaryRepository
              .findByWordIgnoreCase(word)
              .map(entry -> entry.getDefinition())
              .orElse("Word not found.");
      if (cache != null) {
        cache.put(cacheKey, definition);
      }
    }

    return new DictionaryResponse(word, definition, cached);
  }
}
