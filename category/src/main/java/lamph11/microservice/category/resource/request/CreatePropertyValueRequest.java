package lamph11.microservice.category.resource.request;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class CreatePropertyValueRequest {

    @NotEmpty
    @Length(max = 100)
    private String code;

    @NotEmpty
    @Length(max = 100)
    private String name;

    @Length(max = 500)
    private String description;

    @NotNull
    private Integer status;

    @Length(max = 100)
    private String group;

    private String property;

}
