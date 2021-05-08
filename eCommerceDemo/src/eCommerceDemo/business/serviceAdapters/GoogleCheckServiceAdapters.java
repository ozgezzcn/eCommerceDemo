package eCommerceDemo.business.serviceAdapters;

import eCommerceDemo.business.abstracts.SignUpManagerBase;
import eCommerceDemo.business.abstracts.UserService;
import eCommerceDemo.core.services.GoogleCheckManager;

import eCommerceDemo.core.utils.consts.Messages;
import eCommerceDemo.entities.concretes.User;

public class GoogleCheckServiceAdapters extends SignUpManagerBase {

	public GoogleCheckServiceAdapters(UserService userService) {
		super(userService);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void register(User user) {
		GoogleCheckManager googleSignUpManager = new GoogleCheckManager();
		boolean result = googleSignUpManager.login(user.getEmail());
		if(result) {
			super.register(user);
			System.out.println(Messages.googleSignUpSuccessful);
		}else {
			System.out.println(Messages.googleSignUpFailed);
		}
	}
}
