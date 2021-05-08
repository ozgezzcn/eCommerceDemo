package eCommerceDemo.business.abstracts;

import eCommerceDemo.entities.concretes.User;

public interface UserActivationService {
	public void activate(String activationCode);
	public void add(User user);
}
