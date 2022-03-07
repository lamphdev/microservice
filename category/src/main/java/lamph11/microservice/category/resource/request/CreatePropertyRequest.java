package lamph11.microservice.category.resource.request;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class CreatePropertyRequest {

    @NotEmpty
    @Length(max = 100)
    private String name;

    @Length(max = 500)
    private String description;

    @NotNull
    private Integer status;

}
