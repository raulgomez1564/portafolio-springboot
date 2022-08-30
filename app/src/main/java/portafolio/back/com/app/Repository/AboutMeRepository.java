/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package portafolio.back.com.app.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import portafolio.back.com.app.Entity.AboutMe;

/**
 *
 * @author acer
 */
@Repository
public interface AboutMeRepository extends JpaRepository<AboutMe,Long>{
    
}
