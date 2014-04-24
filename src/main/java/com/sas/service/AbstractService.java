package com.sas.service;

import org.springframework.data.domain.Pageable;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: pete
 * Date: 4/13/14
 * Time: 6:03 PM
 * To change this template use File | Settings | File Templates.
 */
public interface AbstractService<T, TId extends Serializable> {

    /**
     * Create service record
     *
     * @param obj
     * @return The created service, including the effects of any persistence triggers or auto values
     */
    <S extends T> S create(@NotNull S obj);

    /**
     * @param id
     * @return The matching record or null if no matches found
     */
    T retrieve(@NotNull TId id);

    Iterable<T> retrieveAll();

    /**
     * Update service record
     *
     * @param obj
     * @return The updated service, including the effects of any persistence triggers or auto values
     */
    <S extends T> S update(@NotNull S obj);

    /**
     * Deletes the indicated record if it exists
     *
     * @param id
     */
    void delete(@NotNull TId id);

    /**
     * Deletes the indicated record if it exists
     *
     * @param obj
     */
    void delete(@NotNull T obj);

    /**
     * @return The number of records available.
     */
    Long count();

}
