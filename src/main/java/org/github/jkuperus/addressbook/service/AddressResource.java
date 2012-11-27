package org.github.jkuperus.addressbook.service;

import org.github.jkuperus.addressbook.domain.Address;
import org.github.jkuperus.addressbook.persistence.AddressRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.net.URI;
import static javax.ws.rs.core.MediaType.*;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * @author Jelmer Kuperus
 */
@Named
@Path("/addresses")
public class AddressResource {

    @Inject
    private AddressRepository addressRepository;

    @PostConstruct
    private void initialize() {
        checkNotNull(addressRepository, "addressRepository must not be null.");
    }

    @GET
    @Produces(APPLICATION_JSON)
    public Page<Address> findAll(@DefaultValue("0") @QueryParam("pageStartIndex") int pageStartIndex,
                                 @DefaultValue("0") @QueryParam("pageSize") int pageSize) {

        Pageable pageable;
        if (pageSize > 0) {
            pageable = new PageRequest(pageStartIndex, pageSize);
        } else {
            pageable = new PageRequest(0, Integer.MAX_VALUE);
        }

        return addressRepository.findAll(pageable);
    }

    @GET
    @Path("{id}")
    @Produces(APPLICATION_JSON)
    public Address findById(@PathParam("id") String id) {
        Address address = addressRepository.findOne(id);
        if (address == null) {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
        return address;
    }

    @PUT
    @Path("{id}")
    @Consumes(APPLICATION_JSON)
    public Response update(@PathParam("id") String id, Address update) {

        Address address = addressRepository.findOne(id);

        if (address == null) {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }

        address.setFirstname(update.getFirstname());
        address.setMiddlename(update.getMiddlename());
        address.setLastname(update.getLastname());

        addressRepository.save(address);

        return Response.noContent().build();
    }

    @DELETE
    @Path("{id}")
    public Response delete(@PathParam("id") String id) {
        Address address = addressRepository.findOne(id);

        if (address == null) {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }

        addressRepository.delete(address);

        return Response.noContent().build();
    }

    @POST
    @Consumes(APPLICATION_JSON)
    public Response save(Address address, @Context UriInfo uriInfo) {
        addressRepository.save(address);

        URI uri = uriInfo.getAbsolutePathBuilder()
                                .path(address.getId())
                                .build();

        return Response.created(uri).build();
    }

}
