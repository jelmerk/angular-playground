package org.github.jkuperus.addressbook.service;

import org.github.jkuperus.addressbook.domain.Address;
import org.github.jkuperus.addressbook.persistence.AddressRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * @author Jelmer Kuperus
 */
@Named
public class DefaultAddressService implements AddressService {

    @Inject
    private AddressRepository addressRepository;

    @Override
    public Page<Address> findAll(int pageStartIndex, int pageSize) {
        Pageable pageable;
        if (pageSize > 0) {
            pageable = new PageRequest(pageStartIndex, pageSize);
        } else {
            pageable = new PageRequest(0, Integer.MAX_VALUE);
        }
        return new Page<Address>(addressRepository.findAll(pageable));
    }

    @Override
    public Address findOne(String id) {
        return addressRepository.findOne(id);
    }

    @Override
    public Address save(Address address) {
        return addressRepository.save(address);
    }

    @Override
    public boolean delete(String addressId) {
        Address address = findOne(addressId);

        if (address == null) {
            return false;
        }
        addressRepository.delete(address);
        return true;
    }
}
