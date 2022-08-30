/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package portafolio.back.com.app.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import portafolio.back.com.app.Entity.AboutMe;
import portafolio.back.com.app.Entity.Education;
import portafolio.back.com.app.Service.AboutMeService;
import portafolio.back.com.app.Service.EducationService;

/**
 *
 * @author acer
 */
@RestController
public class EducationController {
    
    @Autowired
    EducationService service;
    
    @GetMapping("/education")
    public List<Education> get(){
        return this.service.get();
    }
    
    @PostMapping("/education")
    public void create(@RequestBody Education entity){
        this.service.save(entity);
    }
    
    @DeleteMapping("/education/{key}")
    public void delete(@PathVariable Long key){
        this.service.delete(key);
    }
    
    @PutMapping("/education/{key}")
    public void edit(@RequestBody Education entity,@PathVariable Long key){
        this.service.edit(entity,key);
    }
}
