/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package portafolio.back.com.app.Service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import portafolio.back.com.app.Entity.AboutMe;
import portafolio.back.com.app.Entity.Education;
import portafolio.back.com.app.Entity.Job;
import portafolio.back.com.app.Entity.Project;
import portafolio.back.com.app.Repository.AboutMeRepository;
import portafolio.back.com.app.Repository.EducationRepository;
import portafolio.back.com.app.Repository.JobRepository;
import portafolio.back.com.app.Repository.ProjectRepository;

/**
 *
 * @author acer
 */
@Service
public class ProjectService{ 
     @Autowired
     private ProjectRepository repository;
    
    public List<Project> get(){
        return this.repository.findAll();
    }
    
    public void save(Project entity){
        this.repository.save(entity);
    }
    
    public void delete(Long key){
        this.repository.deleteById(key);
    }
    
    public Project find(Long key){
        return this.repository.findById(key).orElse(null);
    }
    
    public void edit( Project entity, Long key){
        Project findedEntity = this.repository.findById(key).orElse(null);
        findedEntity.setDescription(entity.getDescription());
        findedEntity.setName(entity.getName());
        findedEntity.setSince(entity.getSince());
        findedEntity.setTittle(entity.getTittle());
        findedEntity.setUntil(entity.getUntil());
        
        this.repository.save(findedEntity);
    }
}
