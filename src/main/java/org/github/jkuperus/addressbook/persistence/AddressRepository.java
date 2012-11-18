package org.github.jkuperus.addressbook.persistence;

import org.github.jkuperus.addressbook.domain.Address;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Jelmer Kuperus
 */
public interface AddressRepository extends MongoRepository<Address, String> {


}
