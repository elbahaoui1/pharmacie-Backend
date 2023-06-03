package ma.project.repositories;

import ma.project.entities.Pharmacie_Garde;
import ma.project.entities.Pharmacie_Garde_PK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PharmacieGardeRepository extends JpaRepository<Pharmacie_Garde, Pharmacie_Garde_PK> {
}
