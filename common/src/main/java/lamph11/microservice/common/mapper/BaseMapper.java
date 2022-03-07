package lamph11.microservice.common.mapper;

import java.util.List;

public interface BaseMapper<E, D> {

    E toEntity(D Dto);

    D toDTO(E entity);

    List<E> toEntity(List<D> dto);

    List<D> toDTO(List<E> entities);
}
