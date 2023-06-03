package ma.project.repositories;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ma.project.entities.Pharmacie;
import ma.project.entities.User;
import ma.project.entities.Ville;
import ma.project.entities.Zone;

public interface UserRepository extends JpaRepository<User, String> {

//	List<Pharmacie> findByVille(Ville ville);


	

}
