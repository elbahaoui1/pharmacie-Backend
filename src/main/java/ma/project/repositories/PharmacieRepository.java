package ma.project.repositories;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ma.project.entities.Pharmacie;
import ma.project.entities.Ville;
import ma.project.entities.Zone;

@Repository
public interface PharmacieRepository extends JpaRepository<Pharmacie, Integer> {

//	List<Pharmacie> findByVille(Ville ville);
	List<Pharmacie> findByZone(Zone zone);

	@Query("SELECT DISTINCT p FROM Pharmacie p JOIN p.zone z JOIN z.ville v JOIN p.pharmacieGardes pg JOIN pg.garde g WHERE v.nom LIKE %?1% AND z.nom LIKE %?2% AND g.type LIKE %?3%")
	List<Pharmacie> findByZoneVillePeriode(String ville, String zone, String periode);

	Pharmacie findById(int id);

}
