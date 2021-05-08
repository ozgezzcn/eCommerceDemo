package eCommerceDemo.business.abstracts;

import eCommerceDemo.entities.concretes.User;

public interface UserValidationService {
	public void validate(User user) throws Exception;
}
