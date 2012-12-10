package org.github.jkuperus.addressbook.backend.service;

import org.github.jkuperus.addressbook.backend.domain.Address;

/**
 * @author Jelmer Kuperus
 */
public interface AddressService {

    Page<Address> findAll(int pageStartIndex, int pageSize);

    Address findOne(String id);

    Address save(Address address) throws ValidationException;

    boolean delete(String addressId);
}
