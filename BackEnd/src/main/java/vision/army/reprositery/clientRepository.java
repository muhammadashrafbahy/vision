package vision.army.reprositery;

import org.springframework.data.jpa.repository.JpaRepository;
import vision.army.entity.*;

import java.util.List;

public interface clientRepository extends JpaRepository<client,Integer> {

    client findByClientName (String clientName);
    client findByClientEmail (String clientEmail);
    client findByPhone (String Phone);
    List<client> findAllByGender (String gender) ;
}