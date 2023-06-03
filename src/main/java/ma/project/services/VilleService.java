package ma.project.services;


import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;



import ma.project.entities.Ville;

import ma.project.repositories.VilleRepository;



@Service

public class VilleService {

    @Autowired
    private VilleRepository cityRepository;

    public List<Ville> getAllCities() {
        return cityRepository.findAll();
    }

    public Ville getCityById(int id) {
       Ville city = cityRepository.findById(id);
        return city;
    }

    public Ville saveCity(Ville city) {
        return cityRepository.save(city);
    }

    public void deleteCity(int id) {
        cityRepository.deleteById(id);
    }
}
