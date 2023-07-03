package com.employeemployee.converter;

import java.util.List;

public interface IConverter<E, D> {

    /***
     * Convert DTO to Entity
     *
     * @param dto
     * @return entity
     */
    E convertToEntity(D dto) throws Exception;

    /***
     * Convert Entity to DTO
     *
     * @param entity
     * @return entity
     */
    D convertToDto(E entity);

    /***
     * Copy DTO to Entity
     *
     * @param entity , dto
     * @return entity
     */

    E copyConvertToEntity(D dto, E entity);


    List<D> convertToDtoList(List<E> entities);

    List<E> convertToEntityList(List<D> dtoList);
}
