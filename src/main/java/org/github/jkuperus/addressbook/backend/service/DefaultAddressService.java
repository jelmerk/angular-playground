package org.github.jkuperus.addressbook.backend.service;

import org.github.jkuperus.addressbook.backend.domain.Address;
import org.github.jkuperus.addressbook.backend.persistence.AddressRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import static com.google.common.base.Preconditions.checkNotNull;
import static com.google.common.base.Preconditions.checkArgument;

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
        checkArgument(pageStartIndex >= 0, "PageStartIndex cannot be less than 0");

        int realPageSize;
        if (pageSize < 0) {
            realPageSize = Integer.MAX_VALUE;
        } else {
            realPageSize = pageSize;
        }

        Pageable pageable = new PageRequest(pageStartIndex, realPageSize, Sort.Direction.ASC, "firstname");
        return new Page<Address>(addressRepository.findAll(pageable));
    }

    @Override
    public Address findOne(String id) {
        checkNotNull(id, "Id cannot be null.");
        return addressRepository.findOne(id);
    }

    @Override
    public Address save(Address address) throws ValidationException {
        checkNotNull(address, "Address cannot be null.");
        if (!isValid(address)) {
            throw new ValidationException();
        }
        return addressRepository.save(address);
    }

    @Override
    public boolean delete(String id) {
        checkNotNull(id, "Id cannot be null.");

        Address address = findOne(id);

        if (address == null) {
            return false;
        }
        addressRepository.delete(address);
        return true;
    }

    protected boolean isValid(Address address) {
        return address.getFirstname() != null && address.getLastname() != null;
    }
}
