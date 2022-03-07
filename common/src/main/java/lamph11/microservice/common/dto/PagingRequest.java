package lamph11.microservice.common.dto;

import lombok.Data;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

@Data
public class PagingRequest {

    protected int page;
    protected int size;

    public Pageable getPage() {
        if (page < 0)
            page = 0;

        if (size <= 0)
            size = 50;

        return PageRequest.of(page, size);
    }

}
