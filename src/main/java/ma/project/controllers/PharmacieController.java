package ma.project.controllers;
import java.util.Collection;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import ma.project.entities.Pharmacie;
import ma.project.entities.Ville;
import ma.project.entities.Zone;
import ma.project.repositories.*;
import ma.project.services.PharmacieService;

@RestController
@RequestMapping("api")
public class PharmacieController {
	@Autowired
	PharmacieRepository pharmacieRepository;
	@Autowired
	ZoneRepository zoneRepository;
	
	@Autowired
	PharmacieService pharmacieService ;
	

//	@GetMapping(value = "/FindByVille")
//	public List<Pharmacie> FindVille(@RequestBody Ville ville){
//		
//		return pharmacieRepository.findByVille(ville);
//		
//	}

	@GetMapping("/FindByZone")
	public List<Pharmacie> FindZone(@RequestBody Zone zone) {

		return pharmacieService.FindZone(zone);

	}

	@GetMapping("/pharmacies/{id}")
	public Pharmacie FindPharmacie(@PathVariable(required = true) int id) {

		return pharmacieService.findById(id);

	}	

	@GetMapping("/all")
	public List<Pharmacie> FindAllPharmacies() {
		return pharmacieService.FindAllPharmacies();
	}

	@GetMapping("/FindByVille")
	public List<Pharmacie> FindByVille(@RequestBody Ville ville) {
		

		return pharmacieService.FindByVille(ville);
	}

	@GetMapping("/")
	public List<Zone> Zone(@RequestBody Ville ville) {
		return zoneRepository.findByVille(ville);
	}
	
	@GetMapping("/villes")

	public List<Ville> findAll() {
		return pharmacieService.findAll();
	}

	@GetMapping("/villes/{nom}/zones")
	public Collection<?> FindByVille(@PathVariable String nom) {
		return pharmacieService.FindByVille(nom);
	}

	@GetMapping("/villes/{ville}/zones/{zone}/pharmacies")
	public List<Pharmacie> FindByZoneVille(@PathVariable String ville, @PathVariable String zone) {
		return pharmacieService.FindByZoneVille(ville, zone);
	}

	@JsonInclude
	@GetMapping("/villes/{ville}/zones/{zone}/pharmacies/garde")
	public List<Pharmacie> FindByZoneVillePeriod(@PathVariable String ville, @PathVariable String zone, @RequestParam(name = "periode") String periode) {
		return pharmacieService.FindByZoneVillePeriod(ville, zone, periode);
	}

//	@GetMapping("/route")
//
//	public String Route(String adresse, int id) {
//
//		String apiKey = "5b3ce3597851110001cf624871d6dc8996284d0a870a9e8c37d87ded";
//
//		Pharmacie pharmacie = pharmacieRepository.findById(id);
//
//		// Getting Cordinations
//		String urlTargetPharmacy = "https://api.openrouteservice.org/geocode/search?api_key=5b3ce3597851110001cf624871d6dc8996284d0a870a9e8c37d87ded&text="
//				+ pharmacie.getAdresse();
//
//		RestTemplate restTemplate = new RestTemplate();
//		String jsonString1 = restTemplate.getForObject(urlTargetPharmacy, String.class);
//		ObjectMapper objectMapper = new ObjectMapper();
//		JsonNode rootNode = objectMapper.readTree(jsonString1);
//		JsonNode coordinatesNode = rootNode.at("/features/0/geometry/coordinates");
//		double lonDepart = coordinatesNode.get(0).asDouble();
//		double latDepart = coordinatesNode.get(1).asDouble();
//
//		String urlCurrentLoc = "https://api.openrouteservice.org/geocode/search?api_key=5b3ce3597851110001cf624871d6dc8996284d0a870a9e8c37d87ded&text="
//				+ adresse;
//
//		RestTemplate restTemplate2 = new RestTemplate();
//		String jsonString2 = restTemplate.getForObject(urlCurrentLoc, String.class);
//		ObjectMapper objectMapper2 = new ObjectMapper();
//		JsonNode rootNode2 = objectMapper.readTree(jsonString2);
//		JsonNode coordinatesNode2 = rootNode.at("/features/0/geometry/coordinates");
//
//		double lonTarget = coordinatesNode2.get(0).asDouble();
//		double latTarget = coordinatesNode2.get(0).asDouble();
//
//		//Getting Route
//		String url = "https://api.openrouteservice.org/v2/directions/driving-car?api_key=" + apiKey + "&start="
//				+ lonDepart + "," + latDepart + "&end=" + lonTarget + "," + latTarget;
//		RestTemplate restTemplate3 = new RestTemplate();
//		String routeJson = restTemplate3.getForObject(url, String.class);
//		return routeJson;
//	}
	
	@GetMapping("/route/{adresse}/{id}")
	public String getRoute(@PathVariable String adresse, @PathVariable int id) throws JsonMappingException, JsonProcessingException {


	    return pharmacieService.getRoute(adresse, id);
	}
	
	@PostMapping("/save")
	public Pharmacie createPharmacie(@RequestBody Pharmacie pharmacie) throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(pharmacie);
		System.out.println(json);
		return pharmacieService.createPharmacie(pharmacie);
	}
	
	@PutMapping("/{id}")
	public Pharmacie updatePharmacie(@PathVariable int id, @RequestBody Pharmacie p) {
		p.setId(id);
		return pharmacieService.createPharmacie(p);
	}
	
	@DeleteMapping("/{id}")
	public void deletePharmacie(@PathVariable int id) {
		pharmacieService.deletePharmacie(id);
	}


}
