package com.mryndina.exhibitions.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name="models")
public class Models {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_model", nullable = false, updatable = false)
    private int idModel;
    @Column(name = "name_model", nullable = false)
    private String nameModel;
    @Column(name = "scale", nullable = false)
    private int scale;
    @Column(name = "pub_hous", nullable = false)
    private String pubHouse;
    @Column(name = "discription", nullable = false)
    private String discription;
    @Column(name = "photo", nullable = false)
    private String photoModel;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "type_categories", nullable = false)
    private TypeModel typeModel;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "od_user_cre", nullable = false)
    private User user;
}
