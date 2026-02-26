package ge.paso22.simpledragonflycacheapp.controller;

import ge.paso22.simpledragonflycacheapp.model.DictionaryResponse;
import ge.paso22.simpledragonflycacheapp.service.DictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dictionary")
public class DictionaryController {

  @Autowired private DictionaryService dictionaryService;

  @GetMapping("/{word}")
  public DictionaryResponse getDefinition(@PathVariable String word) {
    return dictionaryService.getDefinitionWithCacheInfo(word);
  }
}
