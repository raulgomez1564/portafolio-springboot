/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package portafolio.back.com.app.Service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import portafolio.back.com.app.Entity.Skill;
import portafolio.back.com.app.Repository.SkillRepository;

/**
 *
 * @author acer
 */
@Service
public class SkillService{ 
     @Autowired
     private SkillRepository repository;
    
    public List<Skill> get(){
        return this.repository.findAll();
    }
    
    public void save(Skill entity){
        this.repository.save(entity);
    }
    
    public void delete(Long key){
        this.repository.deleteById(key);
    }
    
    public Skill find(Long key){
        return this.repository.findById(key).orElse(null);
    }
    
    public void edit( Skill entity, Long key){
        Skill findedEntity = this.repository.findById(key).orElse(null);
        findedEntity.setDomain(entity.getDomain());
        findedEntity.setName(entity.getName());
        
        this.repository.save(findedEntity);
    }
}
