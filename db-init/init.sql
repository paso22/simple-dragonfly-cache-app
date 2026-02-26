CREATE TABLE IF NOT EXISTS dictionary_entry (
                                                id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
                                                word VARCHAR(255) UNIQUE NOT NULL,
                                                definition TEXT NOT NULL,
                                                updated_at TIMESTAMP NOT NULL DEFAULT NOW()
);

INSERT INTO dictionary_entry(word, definition, updated_at) VALUES
                                                               ('cache', 'A component that transparently stores data for faster retrieval.', NOW()),
                                                               ('dragonfly', 'A fully Redis-compatible, high-performance in-memory data store.', NOW()),
                                                               ('java', 'A versatile, object-oriented programming language widely used for building enterprise applications.', NOW()),
                                                               ('spring', 'An opinionated framework simplifying the development of Java-based applications.', NOW()),
                                                               ('redis', 'An open-source, in-memory data structure store used as a cache and message broker.', NOW()),
                                                               ('database', 'An organized collection of structured data typically stored electronically.', NOW()),
                                                               ('docker', 'A platform used to build, ship, and run software inside lightweight, portable containers.', NOW()),
                                                               ('api', 'A set of definitions and protocols for building and integrating application software.', NOW()),
                                                               ('json', 'A lightweight data-interchange format that is easy for humans to read and write.', NOW()),
                                                               ('yaml', 'A human-friendly, serialization language commonly used for configuration files.', NOW());