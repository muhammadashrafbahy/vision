package vision.army.reprositery;

import org.springframework.data.jpa.repository.JpaRepository;
import vision.army.entity.*;

import java.util.List;

public interface clientRepository extends JpaRepository<client,Integer> {

    client findByClientName (String clientName);
    List<client> findByClientNameContaining (String clientName);
    client findByClientEmail (String clientEmail);
    List<client>  findByPhoneContaining (String Phone);
    List<client> findAllByGender (String gender) ;
}
