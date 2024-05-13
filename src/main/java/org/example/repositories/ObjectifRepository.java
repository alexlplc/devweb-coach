package org.example.repositories;

import org.example.models.Objectif;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ObjectifRepository extends JpaRepository<Objectif, Long> {
    List<Objectif> findByAchieved(boolean achieved);
}
