package com.Portafolio.Portafolio_Backend.Security.Repository;

import com.Portafolio.Portafolio_Backend.Security.Entity.Rol;
import com.Portafolio.Portafolio_Backend.Security.Enums.RolNombre;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository 
public interface RolRepository extends JpaRepository<Rol, Integer> {
    Optional<Rol> findByRolNombre(RolNombre rolNombre);
}
