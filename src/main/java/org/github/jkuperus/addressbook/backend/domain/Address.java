package org.github.jkuperus.addressbook.backend.domain;

import com.google.common.base.Objects;

import javax.annotation.Nullable;
import java.io.Serializable;

/**
 * @author Jelmer Kuperus
 */
public class Address implements Serializable {

    private String id;
    private String firstname;
    private String middlename;
    private String lastname;

    Address() {
    }

    public Address(@Nullable String firstname,
                   @Nullable String middlename,
                   @Nullable String lastname) {
        this(null, firstname, middlename, lastname);
    }

    public Address(@Nullable String id,
                   @Nullable String firstname,
                   @Nullable String middlename,
                   @Nullable String lastname) {
        this.id = id;
        this.firstname = firstname;
        this.middlename = middlename;
        this.lastname = lastname;
    }

    public String getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getMiddlename() {
        return middlename;
    }

    public void setMiddlename(String middlename) {
        this.middlename = middlename;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof Address) {
            Address that = (Address) other;
            return Objects.equal(this.id, that.id);
        }
        return false;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return Objects.toStringHelper(getClass())
                .add("id", id)
                .add("firstname", firstname)
                .add("middlename", middlename)
                .add("lastname", lastname)
                .toString();
    }
}
