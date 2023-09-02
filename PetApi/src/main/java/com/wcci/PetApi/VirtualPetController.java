package com.wcci.PetApi;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class VirtualPetController {
    @Autowired
    VirtualPetRepository virtualPetRepository;

    @GetMapping("/virtual_pet/{id}")
    public ResponseEntity<VirtualPet> getVirtualPet(@PathVariable("id") Long id) {
        Optional<VirtualPet> virtualPet = virtualPetRepository.findById(id);

        if (virtualPet.isPresent()) {
            return new ResponseEntity<>(virtualPet.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/virtual_pet")
    public ResponseEntity<List<VirtualPet>> getAllVirtualPets() {
        List<VirtualPet> virtualPets = virtualPetRepository.findAll();

        if (virtualPets.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<List<VirtualPet>>(virtualPets, HttpStatus.OK);
        }
    }

    @PostMapping("/virtual_pet/add")
    public ResponseEntity<VirtualPet> createVirtualPet(@RequestBody VirtualPet virtualPet) {
        VirtualPet newVirtualPet = virtualPetRepository.save(new VirtualPet(virtualPet.getName(), virtualPet.getBreed(),
                virtualPet.getHunger(), virtualPet.getThirst(), virtualPet.getHappiness()));
        return new ResponseEntity<>(newVirtualPet, HttpStatus.CREATED);
    }

    @DeleteMapping("/virtual_pet/{id}")
    public void deletePet(@PathVariable("id") Long id) {
        virtualPetRepository.deleteById(id);

    }

}
