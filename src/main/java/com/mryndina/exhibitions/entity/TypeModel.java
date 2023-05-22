package com.mryndina.exhibitions.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name="categories")
public class TypeModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_categories", nullable = false)
    private int id;
    @Column(name = "name_categories", nullable = false, unique = true)
    private String name;
    @ManyToMany(mappedBy = "locations")
    private List<Exhibition> exhibitions;



}
