package lamph11.microservice.category.service.mapper;

import lamph11.microservice.category.domain.PropertyValue;
import lamph11.microservice.category.service.dto.PropertyValueDTO;
import lamph11.microservice.common.mapper.BaseMapper;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        uses = {PropertyMapper.class},
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PropertyValueMapper extends BaseMapper<PropertyValue, PropertyValueDTO> {
}
