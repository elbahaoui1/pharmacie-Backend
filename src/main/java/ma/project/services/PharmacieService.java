package ma.project.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import ma.project.dao.IDAO;
import ma.project.entities.Pharmacie;
import ma.project.entities.Ville;
import ma.project.entities.Zone;
import ma.project.repositories.PharmacieRepository;
import ma.project.repositories.VilleRepository;
import ma.project.repositories.ZoneRepository;


@Service
public class PharmacieService implements IDAO<Pharmacie> {
	
	@Autowired
	VilleRepository villeRepository;

	@Autowired
	ZoneRepository zoneRepository;
	
	@Autowired
	PharmacieRepository pharmacieRepository;

	public Pharmacie createPharmacie(Pharmacie p) {
		return pharmacieRepository.save(p);
	}
	
	public void deletePharmacie(int id) {
		Pharmacie p = pharmacieRepository.findById(id);
				
		pharmacieRepository.delete(p);
	}

	public List<Ville> findAll() {
		return villeRepository.findAll();
	}


	public Collection<?> FindByVille(String nom) {
		return zoneRepository.findByVilleName(nom);
	}


	public List<Pharmacie> FindByZoneVille(String ville, String zone) {
		return zoneRepository.findByZoneVille(ville, zone);
	}

	
	public List<Pharmacie> FindByZoneVillePeriod( String ville,  String zone, String periode) {
		return pharmacieRepository.findByZoneVillePeriode(ville, zone, periode);
	}
	

	public List<Pharmacie> FindZone( Zone zone) {

		return pharmacieRepository.findByZone(zone);

	}

	@Override
	public Pharmacie findById( int id) {

		Pharmacie ph = pharmacieRepository.findById(id);

		return ph;

	}

	public List<Pharmacie> FindAllPharmacies() {
		return pharmacieRepository.findAll();
	}

	@GetMapping("/FindByVille")
	public List<Pharmacie> FindByVille( Ville ville) {
		List<Zone> zones = zoneRepository.findByVille(ville);
		List<Pharmacie> pharmacies = new ArrayList<>();
		for (int i = 0; i <= zones.size(); i++) {
			List<Pharmacie> ph = pharmacieRepository.findByZone(zones.get(i));
			for (int j = 0; j < ph.size(); j++) {
				pharmacies.add(ph.get(j));
			}
			return pharmacies;
		}

		return pharmacies;
	}
	
	public String getRoute( String adresse,  int id) throws JsonMappingException, JsonProcessingException {

	    String apiKey = "5b3ce3597851110001cf624871d6dc8996284d0a870a9e8c37d87ded";
	    Pharmacie pharmacie = pharmacieRepository.findById(id);

	    // Getting Target Pharmacy Coordinates
	    String urlTargetPharmacy = "https://api.openrouteservice.org/geocode/search?api_key=" + apiKey + "&text="
	            + pharmacie.getAdresse();

	    RestTemplate restTemplate = new RestTemplate();
	    String jsonString1 = restTemplate.getForObject(urlTargetPharmacy, String.class);
	    ObjectMapper objectMapper = new ObjectMapper();
	    JsonNode rootNode = objectMapper.readTree(jsonString1);
	    JsonNode coordinatesNode = rootNode.at("/features/0/geometry/coordinates");
	    double lonTarget = coordinatesNode.get(0).asDouble();
	    double latTarget = coordinatesNode.get(1).asDouble();

	    // Getting Current Location Coordinates
	    String urlCurrentLoc = "https://api.openrouteservice.org/geocode/search?api_key=" + apiKey + "&text="
	            + adresse;

	    String jsonString2 = restTemplate.getForObject(urlCurrentLoc, String.class);
	    JsonNode rootNode2 = objectMapper.readTree(jsonString2);
	    JsonNode coordinatesNode2 = rootNode2.at("/features/0/geometry/coordinates");

	    double lonDepart = coordinatesNode2.get(0).asDouble();
	    double latDepart = coordinatesNode2.get(1).asDouble();

	    // Getting Route
	    String urlRoute = "https://api.openrouteservice.org/v2/directions/driving-car?api_key=" + apiKey + "&start="
	            + lonDepart + "," + latDepart + "&end=" + lonTarget + "," + latTarget;

	    RestTemplate restTemplate3 = new RestTemplate();
	    String routeJson = restTemplate3.getForObject(urlRoute, String.class);

	    return routeJson;
	}
	
	@Override
	public Pharmacie Save(Pharmacie pharmacie) {
		return pharmacieRepository.save(pharmacie);
	}
	@Override
	public void Modify(Pharmacie pharmacie) {
		 pharmacieRepository.save(pharmacie);
	}
	@Override
	public void Delete(int id) {
		pharmacieRepository.deleteById(id);
	}
		
	

}
