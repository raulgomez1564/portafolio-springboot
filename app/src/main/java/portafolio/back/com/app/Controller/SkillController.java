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
import portafolio.back.com.app.Entity.Skill;
import portafolio.back.com.app.Service.SkillService;

/**
 *
 * @author acer
 */
@RestController
public class SkillController {
    
    @Autowired
    SkillService service;
    
    @GetMapping("/skill")
    public List<Skill> get(){
        return this.service.get();
    }
    
    @PostMapping("/skill")
    public void create(@RequestBody Skill entity){
        this.service.save(entity);
    }
    
    @DeleteMapping("/skill/{key}")
    public void delete(@PathVariable Long key){
        this.service.delete(key);
    }
    
    @PutMapping("/skill/{key}")
    public void edit(@RequestBody Skill entity,@PathVariable Long key){
        this.service.edit(entity,key);
    }
}
