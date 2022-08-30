/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package portafolio.back.com.app.Controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import portafolio.back.com.app.Entity.AboutMe;
import portafolio.back.com.app.Model.ImageModel;
import portafolio.back.com.app.Service.AboutMeService;

/**
 *
 * @author acer
 */
@RestController
public class AboutMeController {
    
    @Autowired
    AboutMeService service;
    
    @GetMapping("/about-me")
    public List<AboutMe> get(){
        return this.service.get();
    }
    
    @GetMapping("/about-me/image")
    public String getImage( HttpServletResponse response) throws IOException{
        return this.service.getImage();
    }
    
    @PostMapping("/about-me/image")
    public void createImage(@RequestBody ImageModel entity) throws FileNotFoundException{
        this.service.createImage(entity);
    }
    
    @PostMapping("/about-me")
    public void create(@RequestBody AboutMe entity){
        this.service.save(entity);
    }
    
    @DeleteMapping("/about-me/{key}")
    public void delete(@PathVariable Long key){
        this.service.delete(key);
    }
    
    @PutMapping("/about-me/{key}")
    public void edit(@RequestBody AboutMe entity,@PathVariable Long key, HttpServletResponse response){
        try {
            this.service.edit(entity,key);
        } catch (FileNotFoundException e) {
            response.setStatus( HttpServletResponse.SC_INTERNAL_SERVER_ERROR );
        }
    }
}
