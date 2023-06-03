package ma.project.repositories;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import ma.project.entities.Pharmacie;
import ma.project.entities.Ville;
import ma.project.entities.Zone;
@Repository
public interface VilleRepository extends JpaRepository<Ville, Integer> {

//	List<Pharmacie> findByVille(Ville ville);



 Ville findById(int id);

}
