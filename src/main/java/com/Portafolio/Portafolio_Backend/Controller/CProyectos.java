package com.Portafolio.Portafolio_Backend.Controller;

import com.Portafolio.Portafolio_Backend.Dto.dtoProyectos;
import com.Portafolio.Portafolio_Backend.Entity.Proyectos;
import com.Portafolio.Portafolio_Backend.Security.Controller.Mensaje;
import com.Portafolio.Portafolio_Backend.Service.SProyectos;
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
@RequestMapping("/proyectos")
//http://localhost:4200
@CrossOrigin(origins = "https://rios-gonzaloportafolio.web.app")
public class CProyectos {
    @Autowired
    SProyectos sProyectos;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Proyectos>> list(){
        List<Proyectos> list = sProyectos.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Proyectos> getById(@PathVariable("id") int id){
        if(!sProyectos.existsById(id))
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
        Proyectos proyectos = sProyectos.getOne(id).get();
        return new ResponseEntity(proyectos, HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!sProyectos.existsById(id)) {
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
        }
        sProyectos.delete(id);
        return new ResponseEntity(new Mensaje("Proyecto eliminado"), HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoProyectos dtoproyectos){      
        if(StringUtils.isBlank(dtoproyectos.getNombreP())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        } else {
        }
        if(sProyectos.existsByNombreP(dtoproyectos.getNombreP()))
            return new ResponseEntity(new Mensaje("Esa proyecto ya existe"), HttpStatus.BAD_REQUEST);
        
        Proyectos proyectos = new Proyectos(dtoproyectos.getNombreP(), dtoproyectos.getDescripcionP(), 
                dtoproyectos.getImagenP());
        sProyectos.save(proyectos);
        
        return new ResponseEntity(new Mensaje("Proyecto agregado"), HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoProyectos dtoproyectos){
        //Validamos si existe el ID
        if(!sProyectos.existsById(id))
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.BAD_REQUEST);
        //Compara nombre de proyectos
        if(sProyectos.existsByNombreP(dtoproyectos.getNombreP()) && sProyectos.getByNombreP(dtoproyectos.getNombreP()).get().getId() != id)
            return new ResponseEntity(new Mensaje("Ese proyecto ya existe"), HttpStatus.BAD_REQUEST);
        //No puede estar vacio
        if(StringUtils.isBlank(dtoproyectos.getNombreP()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        
        Proyectos proyectos = sProyectos.getOne(id).get();
        proyectos.setNombreP(dtoproyectos.getNombreP());
        proyectos.setDescripcionP((dtoproyectos.getDescripcionP()));
        proyectos.setImagenP((dtoproyectos.getImagenP()));
        
        sProyectos.save(proyectos);
        return new ResponseEntity(new Mensaje("Experiencia actualizada"), HttpStatus.OK);
             
    }
}
