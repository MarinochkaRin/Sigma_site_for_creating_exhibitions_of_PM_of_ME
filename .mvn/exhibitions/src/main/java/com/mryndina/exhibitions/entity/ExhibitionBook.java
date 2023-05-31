package com.mryndina.exhibitions.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "exhibitions_modelss")
public class ExhibitionBook {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "exhibition_id")
    private Exhibition exhibition;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "models_id")
    private Book book;


}
