package ma.project.controllers;

import ma.project.entities.Pharmacie_Garde;
import ma.project.entities.Pharmacie_Garde_PK;
import ma.project.repositories.PharmacieGardeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/pharmacies-garde")
public class PharmacieGardeController {

    private final PharmacieGardeRepository pharmacieGardeRepository;

    @Autowired
    public PharmacieGardeController(PharmacieGardeRepository pharmacieGardeRepository) {
        this.pharmacieGardeRepository = pharmacieGardeRepository;
    }

    @GetMapping
    public ResponseEntity<List<Pharmacie_Garde>> getAllPharmaciesGarde() {
        List<Pharmacie_Garde> pharmaciesGarde = pharmacieGardeRepository.findAll();
        return ResponseEntity.ok(pharmaciesGarde);
    }

    @GetMapping("/{pharmacie}/{garde}/{dateDebut}/{dateFin}")
    public ResponseEntity<Pharmacie_Garde> getPharmacieGarde(@PathVariable int pharmacie, @PathVariable int garde, @PathVariable Date dateDebut, @PathVariable Date dateFin) {
        Optional<Pharmacie_Garde> pharmacieGarde = pharmacieGardeRepository.findById(new Pharmacie_Garde_PK(pharmacie, garde, dateDebut, dateFin));
        return pharmacieGarde.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Pharmacie_Garde> createPharmacieGarde(@RequestBody Pharmacie_Garde pharmacieGarde) {
        Pharmacie_Garde savedPharmacieGarde = pharmacieGardeRepository.save(pharmacieGarde);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedPharmacieGarde);
    }

    @PutMapping("/{pharmacie}/{garde}/{dateDebut}/{dateFin}")
    public ResponseEntity<Pharmacie_Garde> updatePharmacieGarde(@PathVariable int pharmacie, @PathVariable int garde, @PathVariable Date dateDebut, @PathVariable Date dateFin, @RequestBody Pharmacie_Garde pharmacieGarde) {
        Optional<Pharmacie_Garde> existingPharmacieGarde = pharmacieGardeRepository.findById(new Pharmacie_Garde_PK(pharmacie, garde, dateDebut, dateFin));
        if (existingPharmacieGarde.isPresent()) {
            pharmacieGarde.setPharmacie(existingPharmacieGarde.get().getPharmacie());
            pharmacieGarde.setGarde(existingPharmacieGarde.get().getGarde());
            Pharmacie_Garde updatedPharmacieGarde = pharmacieGardeRepository.save(pharmacieGarde);
            return ResponseEntity.ok(updatedPharmacieGarde);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{pharmacie}/{garde}/{dateDebut}/{dateFin}")
    public ResponseEntity<Void> deletePharmacieGarde(@PathVariable int pharmacie, @PathVariable int garde, @PathVariable Date dateDebut, @PathVariable Date dateFin) {
        pharmacieGardeRepository.deleteById(new Pharmacie_Garde_PK(pharmacie, garde, dateDebut, dateFin));
        return ResponseEntity.noContent().build();
    }
}
