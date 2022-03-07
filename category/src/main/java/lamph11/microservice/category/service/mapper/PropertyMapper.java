package lamph11.microservice.category.service.mapper;

import lamph11.microservice.category.domain.Property;
import lamph11.microservice.category.service.dto.PropertyDTO;
import lamph11.microservice.common.mapper.BaseMapper;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PropertyMapper extends BaseMapper<Property, PropertyDTO> {
}
