package services.base;

import models.entity.User;
import models.service.UserServiceModel;
import org.modelmapper.ModelMapper;
import services.HashingService;
import services.UsersService;
import services.UsersValidationService;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

public class UsersServiceImpl implements UsersService {
    private final EntityManager entityManager;
    private final HashingService hashingService;
    private final ModelMapper mapper;
    private final UsersValidationService usersValidationService;

    @Inject
    public UsersServiceImpl(
            EntityManager entityManager,
            HashingService hashingService,
            ModelMapper mapper,
            UsersValidationService usersValidationService) {
        this.entityManager = entityManager;
        this.hashingService = hashingService;
        this.mapper = mapper;
        this.usersValidationService = usersValidationService;
    }

    @Override
    public void register(String username, String email, String password, String confirmPassword) throws Exception {
        if(!usersValidationService.canCreateUser(username, email, password, confirmPassword)) {
            throw new Exception("User cannot be created");
        }

        User user = new User();
        user.setUsername(username);
        user.setEmail(email);
        user.setPassword(hashingService.hash(password));

        entityManager.getTransaction().begin();
        entityManager.persist(user);
        entityManager.getTransaction().commit();
    }

    @Override
    public UserServiceModel login(String username, String password) {
        // check for user with username
        List<User> users = entityManager.createQuery(
                "select u from User u where u.username = :username", User.class)
                .setParameter("username", username)
                .getResultList();
        if(users.isEmpty()) {
            return null;
        }
        User user = users.get(0);

        if(!user.getPassword().equals(hashingService.hash(password))) {
            return null;
        }

        return mapper.map(user, UserServiceModel.class);
    }
}
