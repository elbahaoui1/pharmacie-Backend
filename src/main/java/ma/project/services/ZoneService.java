package ma.project.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import ma.project.entities.Ville;
import ma.project.entities.Zone;
import ma.project.repositories.VilleRepository;
import ma.project.repositories.ZoneRepository;


@Service
public class ZoneService {
	@Autowired
	private ZoneRepository zoneRepository;
@Autowired
	private VilleRepository villeRepository;
	public List<Zone> getAllZones() {
		return zoneRepository.findAll();
	}

	public List<Zone> getZonesByCity(Ville city) {
	    return zoneRepository.findByVille(city);
	}


	public Zone getZoneById(int id) {
		return zoneRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Zone not found with id " + id));
	}

	public Zone createZone(Zone zone) {
		return zoneRepository.save(zone);
	}

	public Zone updateZone(int id, Zone zoneDetails) {
		Zone zone = zoneRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Zone not found with id " + id));
		zone.setNom(zoneDetails.getNom());
		zone.setVille(zoneDetails.getVille());
		return zoneRepository.save(zone);
	}

	public void deleteZone(int id) {
		Zone zone = zoneRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Zone not found with id " + id));
		zoneRepository.delete(zone);
	}
}
