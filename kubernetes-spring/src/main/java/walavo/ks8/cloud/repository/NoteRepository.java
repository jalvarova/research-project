package walavo.ks8.cloud.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import walavo.ks8.cloud.document.Note;

@Repository
public interface NoteRepository extends MongoRepository<Note, String> {

}