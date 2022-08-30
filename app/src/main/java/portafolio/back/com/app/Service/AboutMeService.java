/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package portafolio.back.com.app.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import portafolio.back.com.app.Entity.AboutMe;
import portafolio.back.com.app.Model.ImageModel;
import portafolio.back.com.app.Repository.AboutMeRepository;

/**
 *
 * @author acer
 */
@Service
public class AboutMeService {

    @Autowired
    private AboutMeRepository repository;
    @Autowired
    private ServletContext servletContext;

    public List<AboutMe> get() {
        List<AboutMe> result = this.repository.findAll();
        if(result.isEmpty()){
            AboutMe aboutMe = new AboutMe();
            aboutMe.setName("DefaultName");
            aboutMe.setProfessionalTittle("Development Studen");
            aboutMe.setPresentation("Lorem ipsum dolor sit amet consectetur adipisicing elit. Assumenda officia, pariatur veniam sapiente optio unde ipsam in at provident excepturi hic est molestias quos! Tempore optio facilis repellendus laudantium numquam.");
            this.repository.save(aboutMe);
            
            result.add(aboutMe);
        }
        if(result.size() > 1){
            for (AboutMe aboutMe : result) {
                if(!aboutMe.getId().equals(result.get(0).getId())){
                    this.repository.deleteById(aboutMe.getId());    
                }
            }
        }
        return result;
    }
    
    public String getImage() throws IOException {
        File theDir = new File("images");
        if (!theDir.exists()) {
            theDir.mkdirs();
        }
        File theImage = new File("images/aboutMeImg.txt");
        if (!theImage.exists()) {
            theImage.createNewFile();
        }
        
        Path filePath = Paths.get("images/aboutMeImg.txt");
        return new String(Files.readAllBytes(filePath));
    }

    public void createImage(ImageModel image) throws FileNotFoundException {
        File theDir = new File("images");
        if (!theDir.exists()) {
            theDir.mkdirs();
        }
        PrintWriter out = new PrintWriter("images/aboutMeImg.txt");
        out.print(image.getContent());
        out.close();
    }
        
    public void save(AboutMe aboutMe) {
        this.repository.save(aboutMe);
    }

    public void delete(Long key) {
        this.repository.deleteById(key);
    }

    public AboutMe find(Long key) {
        return this.repository.findById(key).orElse(null);
    }

    public boolean edit(AboutMe aboutMe, Long key) throws FileNotFoundException {
        AboutMe findedAboutMe = this.repository.findById(key).orElse(null);
        findedAboutMe.setName(aboutMe.getName());
        findedAboutMe.setPresentation(aboutMe.getPresentation());
        findedAboutMe.setProfessionalTittle(aboutMe.getProfessionalTittle());

        this.repository.save(findedAboutMe);
        return true;
    }
}
