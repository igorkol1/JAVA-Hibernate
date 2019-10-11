package pl.coderslab.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.entities.Publisher;

public interface PublisherRepository extends JpaRepository<Publisher,Long> {

    Publisher findByNip(String nip);

    Publisher findByRegon(String regon);

}
