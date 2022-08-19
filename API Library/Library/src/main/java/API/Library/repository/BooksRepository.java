package API.Library.repository;

import API.Library.model.BooksModel;
import org.springframework.data.repository.CrudRepository;

public interface BooksRepository extends CrudRepository <BooksModel, Integer> {
}
