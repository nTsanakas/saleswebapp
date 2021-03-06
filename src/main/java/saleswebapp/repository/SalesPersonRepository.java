package saleswebapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import saleswebapp.repository.impl.SalesPerson;

import java.io.Serializable;

/**
 * Created by Alexander Carl on 04.06.2017.
 */
@Repository
public interface SalesPersonRepository extends JpaRepository<SalesPerson, Serializable> {

    SalesPerson getByEmail(String userEmail);

    SalesPerson getById(int id);
}
