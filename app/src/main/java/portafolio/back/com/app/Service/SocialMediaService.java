/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package portafolio.back.com.app.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import portafolio.back.com.app.Entity.SocialMedia;
import portafolio.back.com.app.Model.ImageModel;
import portafolio.back.com.app.Repository.SocialMediaRepository;

/**
 *
 * @author acer
 */
@Service
public class SocialMediaService{ 
     @Autowired
     private SocialMediaRepository repository;
    
    public List<SocialMedia> get(){
        List<SocialMedia> medias = this.repository.findAll();
        if(medias.size() != 2){
            for (SocialMedia media : medias) {
                this.repository.deleteById(media.getName());
            }
            SocialMedia facebook = new SocialMedia();
            facebook.setName("facebook");
            facebook.setUrl("");
            SocialMedia instagram = new SocialMedia();
            instagram.setName("instagram");
            instagram.setUrl("");
            this.repository.save(facebook);
            this.repository.save(instagram);
        }
        return this.repository.findAll();
    }
    
    public void save(SocialMedia entity){
        this.repository.save(entity);
    }
    
    public void delete(String key){
        this.repository.deleteById(key);
    }
    
    public SocialMedia find(String key){
        return this.repository.findById(key).orElse(null);
    }
    
    public void edit( SocialMedia entity, String key){
        SocialMedia findedEntity = this.repository.findById(key).orElse(null);
        findedEntity.setName(entity.getName());
        findedEntity.setUrl(entity.getUrl());

        this.repository.save(findedEntity);
    }

    public void createImage(ImageModel image) throws FileNotFoundException {
        File theDir = new File("images");
        if (!theDir.exists()) {
            theDir.mkdirs();
        }
        PrintWriter out = new PrintWriter("images/bannerImg.txt");
        out.print(image.getContent());
        out.close();
    }

    public String getImage() throws IOException {
        File theDir = new File("images");
        if (!theDir.exists()) {
            theDir.mkdirs();
        }
        File theImage = new File("images/bannerImg.txt");
        if (!theImage.exists()) {
            theImage.createNewFile();
        }
        
        Path filePath = Paths.get("images/bannerImg.txt");
        return new String(Files.readAllBytes(filePath));
    }
}
