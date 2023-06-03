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

import ma.project.entities.Ville;
import ma.project.services.VilleService;



@RestController
@RequestMapping("/api/Villes")
public class VilleController {

    @Autowired
    private VilleService villeService;

    @GetMapping("")
    public List<Ville> getAllCities() {
        return villeService.getAllCities();
    }

    @GetMapping("/{id}")
    public Ville getCityById(@PathVariable int id) {
        return villeService.getCityById(id);
    }

    @PostMapping("")
    public Ville createCity(@RequestBody Ville city) {
        return villeService.saveCity(city);
    }

    @PutMapping("/{id}")
    public Ville updateCity(@PathVariable int id, @RequestBody Ville city) {
    	Ville existingCity = villeService.getCityById(id);
        if (existingCity != null) {
            existingCity.setNom(city.getNom());
            return villeService.saveCity(existingCity);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteCity(@PathVariable int id) {
    	villeService.deleteCity(id);
    }
}
