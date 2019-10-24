package services;

public interface UsersValidationService {
    boolean canCreateUser(String username, String email, String password, String confirmPassword);
}
