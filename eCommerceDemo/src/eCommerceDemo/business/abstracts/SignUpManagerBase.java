package eCommerceDemo.business.abstracts;

import eCommerceDemo.core.services.SignUpService;
import eCommerceDemo.entities.concretes.User;

public abstract class SignUpManagerBase implements SignUpService {
	private UserService userService;
	
	public SignUpManagerBase(UserService userService) {		
		this.userService = userService;
	}
	
	//@Override
	public void register(User user) {
		this.userService.add(user);
	}
}
