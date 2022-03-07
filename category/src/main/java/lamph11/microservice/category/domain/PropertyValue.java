package lamph11.microservice.category.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "property_value", uniqueConstraints = {
        @UniqueConstraint(name = "PROP_VALUE_UNIQUE", columnNames = {"code", "property"})
})
public class PropertyValue {

    @Id
    @Column(length = 100)
    private String code;

    @Column(length = 100, nullable = false)
    private String name;

    @Column(length = 500)
    private String description;

    @Column(nullable = false)
    private Integer status;

    @Column(length = 100)
    private String group;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "property", nullable = false )
    private Property property;

}
