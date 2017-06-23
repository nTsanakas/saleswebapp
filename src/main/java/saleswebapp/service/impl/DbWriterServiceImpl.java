package saleswebapp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.stereotype.Service;
import saleswebapp.components.DTO.ProfileForm;
import saleswebapp.domain.repository.CountryRepository;
import saleswebapp.domain.repository.SalesPersonRepository;
import saleswebapp.domain.repository.impl.Country;
import saleswebapp.domain.repository.impl.SalesPerson;
import saleswebapp.service.DbWriterService;

import javax.transaction.Transactional;

/**
 * Created by Alexander Carl on 18.06.2017.
 */
@Service
public class DbWriterServiceImpl  implements DbWriterService {

    @Autowired
    private SalesPersonRepository salesPersonRepository;

    @Autowired
    private CountryRepository countryRepository;

    private ShaPasswordEncoder encoder = new ShaPasswordEncoder(256);

    @Override
    public void setNewPassword(String userEmail, String encodedPassword) {
        SalesPerson salesPerson = salesPersonRepository.getByEmail(userEmail);
        salesPerson.setPassword(encodedPassword);
        salesPersonRepository.saveAndFlush(salesPerson);
    }

    @Override
    public void setNewPassword(Integer userId, String encodedPassword) {
        SalesPerson salesPerson = salesPersonRepository.getById(userId);
        salesPerson.setPassword(encodedPassword);
        salesPersonRepository.saveAndFlush(salesPerson);
    }


    @Override
    @Transactional
    public void saveProfileChange(ProfileForm profileForm) {
        SalesPerson salesPerson = salesPersonRepository.getById(profileForm.getId());
        salesPerson.setFirstName(profileForm.getFirstName());
        salesPerson.setSecondName(profileForm.getSecondName());
        salesPerson.setStreet(profileForm.getStreet());
        salesPerson.setStreetNumber(profileForm.getStreetNumber());
        salesPerson.setZip(profileForm.getZip());
        salesPerson.setCity(profileForm.getCity());
        salesPerson.setPhone(profileForm.getPhone());
        salesPerson.setCountry(profileForm.getCountry());
        salesPerson.setEmail(profileForm.getEmail());
        salesPerson.setIban(profileForm.getIban());
        salesPerson.setBic(profileForm.getBic());

        salesPersonRepository.saveAndFlush(salesPerson);
    }


}