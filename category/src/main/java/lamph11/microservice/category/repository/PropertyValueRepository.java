package lamph11.microservice.category.repository;

import lamph11.microservice.category.domain.PropertyValue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface PropertyValueRepository extends JpaRepository<PropertyValue, String>,
        JpaSpecificationExecutor<PropertyValue> {
}
