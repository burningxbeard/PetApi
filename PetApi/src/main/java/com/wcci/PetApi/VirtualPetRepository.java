package com.wcci.PetApi;

import org.springframework.data.jpa.repository.JpaRepository;

public interface VirtualPetRepository extends JpaRepository<VirtualPet, Long> {
    
}
