package lamph11.microservice.category.service.dto;

import lombok.Data;

@Data
public class PropertyValueDTO {

    private String code;

    private String name;

    private String description;

    private Integer status;

    private String group;

    private PropertyDTO property;

}
