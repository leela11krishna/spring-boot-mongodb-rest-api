package in.revathi.restapi.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import in.revathi.restapi.model.CatalogModel;

@Repository
public interface CatalogDAO extends MongoRepository<CatalogModel, Long> {

}
