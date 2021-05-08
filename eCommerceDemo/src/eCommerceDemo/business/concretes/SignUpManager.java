package eCommerceDemo.business.concretes;

import eCommerceDemo.business.abstracts.SignUpManagerBase;
import eCommerceDemo.business.abstracts.UserService;

public class SignUpManager extends SignUpManagerBase {

	public SignUpManager(UserService userService) {
		super(userService);
		
	}
}
