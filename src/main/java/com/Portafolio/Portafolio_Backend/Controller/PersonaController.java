package com.Portafolio.Portafolio_Backend.Controller;

import com.Portafolio.Portafolio_Backend.Dto.dtoPersona;
import com.Portafolio.Portafolio_Backend.Entity.Persona;
import com.Portafolio.Portafolio_Backend.Security.Controller.Mensaje;
import com.Portafolio.Portafolio_Backend.Service.SPersona;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/persona")
//http://localhost:4200
@CrossOrigin(origins = "https://rios-gonzaloportafolio.web.app")
public class PersonaController {
    @Autowired
    SPersona sPersona;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Persona>> list(){
        List<Persona> list = sPersona.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Persona> getById(@PathVariable("id") int id){
        if(!sPersona.existsById(id))
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
        Persona persona = sPersona.getOne(id).get();
        return new ResponseEntity(persona, HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!sPersona.existsById(id)) {
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
        }
        sPersona.delete(id);
        return new ResponseEntity(new Mensaje("Persona eliminada"), HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoPersona dtopersona){      
        if(StringUtils.isBlank(dtopersona.getNombre())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        } else {
        }
        if(sPersona.existsByNombre(dtopersona.getNombre()))
            return new ResponseEntity(new Mensaje("Esa persona ya existe"), HttpStatus.BAD_REQUEST);
        
        Persona persona = new Persona(dtopersona.getNombre(), dtopersona.getApellido(), 
                dtopersona.getImg(), dtopersona.getTelefono(), dtopersona.getEmail(), dtopersona.getPerfil(),
                dtopersona.getBanner(), dtopersona.getAcerca_demi());
        sPersona.save(persona);
        
        return new ResponseEntity(new Mensaje("Persona agregada"), HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoPersona dtopersona){
        //Validamos si existe el ID
        if(!sPersona.existsById(id))
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.BAD_REQUEST);
        //Compara nombre de proyectos
        if(sPersona.existsByNombre(dtopersona.getNombre()) && sPersona.getByNombre(dtopersona.getNombre()).get().getId() != id)
            return new ResponseEntity(new Mensaje("Esa persona ya existe"), HttpStatus.BAD_REQUEST);
        //No puede estar vacio
        if(StringUtils.isBlank(dtopersona.getNombre()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        
        Persona persona = sPersona.getOne(id).get();
        persona.setNombre(dtopersona.getNombre());
        persona.setApellido(dtopersona.getApellido());
        persona.setImg(dtopersona.getImg());
        persona.setTelefono(dtopersona.getTelefono());
        persona.setEmail(dtopersona.getEmail());
        persona.setPerfil(dtopersona.getPerfil());
        persona.setBanner(dtopersona.getBanner());
        
        sPersona.save(persona);
        return new ResponseEntity(new Mensaje("Persona actualizada"), HttpStatus.OK);
             
    }
}