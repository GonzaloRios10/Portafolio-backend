package com.Portafolio.Portafolio_Backend.Repository;

import com.Portafolio.Portafolio_Backend.Entity.Experiencia;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RExperiencia extends JpaRepository <Experiencia, Integer>{
    public Optional<Experiencia> findByNombreE(String nombreE);
    public boolean existsByNombreE(String nombreE);
}
