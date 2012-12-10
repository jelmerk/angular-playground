package org.github.jkuperus.addressbook.web.resource;

import org.github.jkuperus.addressbook.backend.domain.Address;
import org.github.jkuperus.addressbook.backend.service.AddressService;
import org.github.jkuperus.addressbook.backend.service.Page;
import org.github.jkuperus.addressbook.backend.service.ValidationException;

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
    private AddressService addressService;

    @PostConstruct
    private void initialize() {
        checkNotNull(addressService, "addressService must not be null.");
    }

    @GET
    @Produces(APPLICATION_JSON)
    public Page<Address> findAll(@DefaultValue("0") @QueryParam("pageStartIndex") int pageStartIndex,
                                 @DefaultValue("0") @QueryParam("pageSize") int pageSize) {

        return addressService.findAll(pageStartIndex, pageSize);
    }

    @GET
    @Path("{id}")
    @Produces(APPLICATION_JSON)
    public Address findById(@PathParam("id") String id) {
        Address address = addressService.findOne(id);
        if (address == null) {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
        return address;
    }

    @PUT
    @Path("{id}")
    @Consumes(APPLICATION_JSON)
    public Response update(@PathParam("id") String id, Address update) {
        Address address = addressService.findOne(id);

        if (address == null) {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }

        address.setFirstname(update.getFirstname());
        address.setMiddlename(update.getMiddlename());
        address.setLastname(update.getLastname());

        try {
            addressService.save(address);
        } catch (ValidationException e) {
            throw new WebApplicationException(Response.Status.BAD_REQUEST);
        }

        return Response.noContent().build();
    }

    @DELETE
    @Path("{id}")
    public Response delete(@PathParam("id") String id) {
        if (!addressService.delete(id)) {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
        return Response.noContent().build();
    }

    @POST
    @Consumes(APPLICATION_JSON)
    public Response save(Address address, @Context UriInfo uriInfo) {
        try {
            addressService.save(address);
        } catch (ValidationException e) {
            throw new WebApplicationException(Response.Status.BAD_REQUEST);
        }

        URI uri = uriInfo.getAbsolutePathBuilder()
                                .path(address.getId())
                                .build();

        return Response.created(uri).build();
    }

}
