package eCommerceDemo.business.abstracts;

import eCommerceDemo.entities.concretes.User;

public interface AuthService {
	public void login(String email, String password);
	public void register(User user);
}
