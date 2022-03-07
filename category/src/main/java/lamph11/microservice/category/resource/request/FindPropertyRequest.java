package lamph11.microservice.category.resource.request;

import lamph11.microservice.common.dto.PagingRequest;
import lombok.Data;

import java.util.List;

@Data
public class FindPropertyRequest extends PagingRequest {

    private List<String> in;
    private Integer status;

}
