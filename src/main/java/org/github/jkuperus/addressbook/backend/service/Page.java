package org.github.jkuperus.addressbook.backend.service;

import java.util.Iterator;
import java.util.List;

/**
 * @author Jelmer Kuperus
 */
public class Page<T> implements Iterable<T> {

    private final org.springframework.data.domain.Page<T> delegate;

    Page(org.springframework.data.domain.Page<T> delegate) {
        this.delegate = delegate;
    }

    /**
     * Returns the number of the current page. Is always positive and less that {@code Page#getTotalPages()}.
     *
     * @return the number of the current page
     */
    public int getNumber() {
        return delegate.getNumber();
    }

    /**
     * Returns the size of the page.
     *
     * @return the size of the page
     */
    public int getSize() {
        return delegate.getSize();
    }

    /**
     * Returns the number of total pages.
     *
     * @return the number of toral pages
     */
    public int getTotalPages() {
        return delegate.getTotalPages();
    }

    /**
     * Returns the number of elements currently on this page.
     *
     * @return the number of elements currently on this page
     */
    public int getNumberOfElements() {
        return delegate.getNumberOfElements();
    }

    /**
     * Returns the total amount of elements.
     *
     * @return the total amount of elements
     */
    public long getTotalElements() {
        return delegate.getTotalElements();
    }

    /**
     * Returns if there is a previous page.
     *
     * @return if there is a previous page
     */
    public boolean hasPreviousPage() {
        return delegate.hasPreviousPage();
    }

    /**
     * Returns whether the current page is the first one.
     *
     * @return whether the current page is the first one
     */
    public boolean isFirstPage() {
        return delegate.isFirstPage();
    }

    /**
     * Returns if there is a next page.
     *
     * @return if there is a next page
     */
    public boolean hasNextPage() {
        return delegate.hasNextPage();
    }

    /**
     * Returns whether the current page is the last one.
     *
     * @return whether the current page is the last one
     */
    public boolean isLastPage() {
        return delegate.isLastPage();
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Iterable#iterator()
     */
    public Iterator<T> iterator() {
        return delegate.iterator();
    }

    /**
     * Returns the page content as {@link List}.
     *
     * @return the page content as {@link List}
     */
    public List<T> getContent() {
        return delegate.getContent();
    }

    /**
     * Returns whether the {@link Page} has content at all.
     *
     * @return whether the {@link Page} has content at all
     */
    public boolean hasContent() {
        return delegate.hasContent();
    }

}
