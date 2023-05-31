package com.mryndina.exhibitions.repository;

import com.mryndina.exhibitions.entity.Location;
import com.mryndina.exhibitions.entity.Exhibition;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.Optional;
import java.util.Set;

public interface ExhibitionRepository extends JpaRepository<Exhibition, Integer> {
    long countByIsActiveIs(boolean isActive);

    Exhibition findById(int exhibitionId);

    Page<Exhibition> findAll(Pageable page);

    @Query("select e from Exhibition e where (:from is null or e.endDate >= :from) and (:to is null or e.startDate <= :to) and e.isActive = true")
    Page<Exhibition> findByStartDateBetweenAndIsActive(LocalDate from, LocalDate to, Pageable page);

    @Query("select e from Exhibition e where (:from is null or e.endDate >= :from) and (:to is null or e.startDate <= :to)")
    Page<Exhibition> findByStartDateBetween(LocalDate from, LocalDate to, Pageable page);

    @Query("select e from Exhibition e join fetch e.locations where e.id = ?1")
    Optional<Exhibition> findByIdFetchLocations(int exhibitionId);

    @Query("select e.locations from Exhibition e where e.startDate < :endDate and e.endDate > :startDate and e.isActive = true")
    Set<Location> findOccupiedLocations(LocalDate startDate, LocalDate endDate);
}
