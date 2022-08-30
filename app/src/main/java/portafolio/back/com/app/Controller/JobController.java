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
import portafolio.back.com.app.Entity.Job;
import portafolio.back.com.app.Service.AboutMeService;
import portafolio.back.com.app.Service.EducationService;
import portafolio.back.com.app.Service.JobService;

/**
 *
 * @author acer
 */
@RestController
public class JobController {
    
    @Autowired
    JobService service;
    
    @GetMapping("/job")
    public List<Job> get(){
        return this.service.get();
    }
    
    @PostMapping("/job")
    public void create(@RequestBody Job entity){
        this.service.save(entity);
    }
    
    @DeleteMapping("/job/{key}")
    public void delete(@PathVariable Long key){
        this.service.delete(key);
    }
    
    @PutMapping("/job/{key}")
    public void edit(@RequestBody Job entity,@PathVariable Long key){
        this.service.edit(entity,key);
    }
}
