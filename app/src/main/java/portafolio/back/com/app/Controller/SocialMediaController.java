/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package portafolio.back.com.app.Controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import portafolio.back.com.app.Entity.SocialMedia;
import portafolio.back.com.app.Model.ImageModel;
import portafolio.back.com.app.Service.SocialMediaService;

/**
 *
 * @author acer
 */
@RestController
public class SocialMediaController {
    
    @Autowired
    SocialMediaService service;
    
    @GetMapping("/social-media")
    public List<SocialMedia> get(){
        return this.service.get();
    }
    
    @GetMapping("/social-media/image")
    public String getImage( HttpServletResponse response) throws IOException{
        return this.service.getImage();
    }
    
    @PostMapping("/social-media/image")
    public void createImage( @RequestBody ImageModel image) throws IOException{
        this.service.createImage(image);
    }
    
    @PostMapping("/social-media")
    public void create(@RequestBody SocialMedia entity){
        this.service.save(entity);
    }
    
    @DeleteMapping("/social-media/{key}")
    public void delete(@PathVariable String key){
        this.service.delete(key);
    }
    
    @PutMapping("/social-media/{key}")
    public void edit(@RequestBody SocialMedia entity,@PathVariable String key){
        this.service.edit(entity,key);
    }
}
