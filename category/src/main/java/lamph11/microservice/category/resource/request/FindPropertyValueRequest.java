package lamph11.microservice.category.resource.request;

import lamph11.microservice.common.dto.PagingRequest;
import lombok.Data;

@Data
public class FindPropertyValueRequest extends PagingRequest {

    private String property;
    private String keyword;
    private Integer status;

}
