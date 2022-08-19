package API.Library.repository;

import API.Library.model.TransactionsModel;
import org.springframework.data.repository.CrudRepository;

public interface TransactionsRepository extends CrudRepository <TransactionsModel, Integer> {
}