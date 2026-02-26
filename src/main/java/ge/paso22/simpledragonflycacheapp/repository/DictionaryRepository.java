package ge.paso22.simpledragonflycacheapp.repository;

import ge.paso22.simpledragonflycacheapp.model.DictionaryEntry;

import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DictionaryRepository extends JpaRepository<DictionaryEntry, UUID> {
  Optional<DictionaryEntry> findByWordIgnoreCase(String word);
}
