package ma.project.repositories;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ma.project.entities.Garde;
import ma.project.entities.Pharmacie;
import ma.project.entities.User;
import ma.project.entities.Ville;
import ma.project.entities.Zone;

public interface GardeRepository extends JpaRepository<Garde, String> {

//	List<Pharmacie> findByVille(Ville ville);


//	Collection<?> findByid(int id);

}
