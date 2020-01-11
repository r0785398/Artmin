package artmin.service;

import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
 
import artmin.dao.DemoUserDao;
import artmin.model.DemoUser;
 
@Service("userService")
@Transactional
public class UserService{
    @Autowired
    private DemoUserDao dao;
     
    // zoeken van gebruiker op basis van ID
    public DemoUser findById(int id) {
        return dao.findById(id);
    }
 
    // Bewaren van gebruiker
    public void saveUser(DemoUser user) {
        dao.saveUser(user);
    }
 
    // bijwerken van bestaande gebruiker
    public void updateUser(DemoUser user) {
        DemoUser entity = dao.findById(user.getId());
        if(entity!=null){
            entity.setUsername(user.getUsername());
            entity.setPassword(user.getPassword());
            entity.setConfirmPassword(user.getConfirmPassword());
        }
    }
 
    // verwijderen van gebruiker
    public void deleteUserById(int id) {
        dao.deleteUserById(id);
    }
     
    // zoeken van alle gebruikers
    public List<DemoUser> findAllUsers() {
        return dao.findAllUsers();
    }
 
 // controleer of paswoord gelijk is
    public boolean arePasswordsEqual(String password, String confirmPassword) {
        return (password.equals(confirmPassword));
    }
}
