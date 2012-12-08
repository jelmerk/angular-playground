package org.github.jkuperus.addressbook.service;

import org.github.jkuperus.addressbook.domain.Address;

/**
 * @author Jelmer Kuperus
 */
public interface AddressService {

    Page<Address> findAll(int pageStartIndex, int pageSize);

    Address findOne(String id);

    Address save(Address address);

    boolean delete(String addressId);
}
