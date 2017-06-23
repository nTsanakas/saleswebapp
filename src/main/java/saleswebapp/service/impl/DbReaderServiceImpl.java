package saleswebapp.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import saleswebapp.domain.repository.impl.Country;
import saleswebapp.domain.repository.impl.SalesPerson;
import saleswebapp.domain.repository.CountryRepository;
import saleswebapp.domain.repository.SalesPersonRepository;
import saleswebapp.service.DbReaderService;

import java.util.List;

/**
 * Created by Alexander Carl on 04.06.2017.
 */
@Service
public class DbReaderServiceImpl implements DbReaderService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private SalesPersonRepository salesPersonRepository;

    @Autowired
    private CountryRepository countryRepository;

    @Override
    public SalesPerson getSalesPersonByEmail(String email) {
        return salesPersonRepository.getByEmail(email);
    }


    public SalesPerson getSalesPersonById(int id) {
        return salesPersonRepository.getById(id);
    }

    @Override
    public List<Country> getAllCountries() {
        return countryRepository.findAll();
    }

    @Override
    public void testMethodSaveSalesPerson() {
        SalesPerson salesPerson = new SalesPerson();
        salesPerson.setPassword("PW1234");
        salesPerson.setFirstName("FirstName1234");
        salesPerson.setSecondName("SecondName1234");
        salesPerson.setStreet("Street1234");
        salesPerson.setStreetNumber("S-Nr 1234");
        salesPerson.setZip("Z1234");
        salesPerson.setCity("City1234");
        salesPerson.setPhone("Phone1234");
        salesPerson.setCountry(countryRepository.getOne("DE"));
        salesPerson.setEmail("EMAIL1234");
        salesPerson.setIban("IBAN1234");
        salesPerson.setBic("BIC124");
        salesPerson.setSalaryPercentage(0.3);

        salesPersonRepository.save(salesPerson);
    }
}