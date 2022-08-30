/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package portafolio.back.com.app.Service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import portafolio.back.com.app.Entity.Education;
import portafolio.back.com.app.Repository.EducationRepository;

/**
 *
 * @author acer
 */
@Service
public class EducationService{ 
     @Autowired
     private EducationRepository repository;
    
    public List<Education> get(){
        return this.repository.findAll();
    }
    
    public void save(Education entity){
        this.repository.save(entity);
    }
    
    public void delete(Long key){
        this.repository.deleteById(key);
    }
    
    public Education find(Long key){
        return this.repository.findById(key).orElse(null);
    }
    
    public void edit( Education entity, Long key){
        Education findedEntity = this.repository.findById(key).orElse(null);
        findedEntity.setDescription(entity.getDescription());
        findedEntity.setInstitute(entity.getInstitute());
        findedEntity.setSince(entity.getSince());
        findedEntity.setTittle(entity.getTittle());
        findedEntity.setUntil(entity.getUntil());
        
        this.repository.save(findedEntity);
    }
}
