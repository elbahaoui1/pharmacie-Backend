package ma.project.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import ma.project.entities.Ville;
import ma.project.entities.Zone;
import ma.project.repositories.VilleRepository;
import ma.project.services.ZoneService;

@RestController
@RequestMapping("/api/zones")

public class ZoneController {
	@Autowired(required=true)
	private ZoneService zoneService;
	
	@Autowired
	private VilleRepository villeRepository;

	@GetMapping("")
	public List<Zone> getAllCities() {
		return zoneService.getAllZones();
	}

	@GetMapping("/{id}")
	public Zone getZoneById(@PathVariable int id) {
		return zoneService.getZoneById(id);
	}

	@GetMapping("/city/{id}")
	public List<Zone> getZonesByCityId(@PathVariable int id) {
	    Ville city = villeRepository.findById(id);
	    return zoneService.getZonesByCity(city);
	}


	@PostMapping("/save")
	public Zone createZone(@RequestBody Zone zone) throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(zone);
		System.out.println(json);
		return zoneService.createZone(zone);
	}
	
	@PutMapping("/{id}")
	public Zone updateZone(@PathVariable int id, @RequestBody Zone zone) {
		zone.setId(id);
		return zoneService.createZone(zone);
	}

	@DeleteMapping("/{id}")
	public void deleteZone(@PathVariable int id) {
		zoneService.deleteZone(id);
	}

}
