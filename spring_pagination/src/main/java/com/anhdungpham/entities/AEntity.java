package com.anhdungpham.entities;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String AName;

//    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, targetEntity = BEntity.class)
//    @JoinColumn(name="a_b", foreignKey = @ForeignKey(name="fk_ab"), referencedColumnName = "id")
    @ManyToMany(fetch = FetchType.EAGER)
    private List<BEntity> bEntityList = new ArrayList<>();
}
