package API.Library.repository;

import API.Library.model.ClientModel;
import org.springframework.data.repository.CrudRepository;

public interface ClientRepository extends CrudRepository <ClientModel, Integer> {
}
