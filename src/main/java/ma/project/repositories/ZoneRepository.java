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
public interface ZoneRepository extends JpaRepository<Zone, Integer> {

	List<Zone> findByVille(Ville ville);

	@Query("select z.id, z.nom from Zone z join z.ville v where v.nom like %?1%")
	Collection<Object[]> findByVilleName(String name);

	@Query("SELECT p FROM Pharmacie p JOIN p.zone z JOIN z.ville v WHERE  v.nom like %?1% and z.nom like %?2%")
	List<Pharmacie> findByZoneVille(String ville, String zone);
	
	List<Zone> findByVille(int cityId);
	
	List<Zone> findAll();

//	Collection<?> findByid(int id);

}
