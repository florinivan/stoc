package it.phime.stoc.jpa.repository;

import it.phime.stoc.jpa.entity.Stoc;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StocRepository extends JpaRepository<Stoc, Integer> {
    Optional<Stoc> findByIdAndProdId(Integer idm, String prodId);
    // Custom queries or methods can be added here
}