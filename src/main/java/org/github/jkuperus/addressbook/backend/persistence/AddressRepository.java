package org.github.jkuperus.addressbook.backend.persistence;

import org.github.jkuperus.addressbook.backend.domain.Address;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author Jelmer Kuperus
 */
public interface AddressRepository extends MongoRepository<Address, String> {


}
