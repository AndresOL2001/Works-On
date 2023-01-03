package com.work.on.customer.service.dataaccess.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "colors")
@Entity
public class ColorEntity {

    @Id
    private Long colorId;
    @ManyToMany(mappedBy = "colors",cascade=CascadeType.ALL)
    private List<CustomerEntity> customer;
    private String hexadecimal;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ColorEntity that = (ColorEntity) o;
        return Objects.equals(colorId, that.colorId) && Objects.equals(customer, that.customer) && Objects.equals(hexadecimal, that.hexadecimal);
    }

    @Override
    public int hashCode() {
        return Objects.hash(colorId, customer, hexadecimal);
    }
}
