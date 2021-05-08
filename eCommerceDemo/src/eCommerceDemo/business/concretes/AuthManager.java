package eCommerceDemo.business.concretes;

import eCommerceDemo.business.abstracts.AuthService;
import eCommerceDemo.core.services.SignUpService;
import eCommerceDemo.core.utils.consts.Messages;
import eCommerceDemo.dataAccess.abstracts.UserDao;
import eCommerceDemo.entities.concretes.User;

public class AuthManager implements AuthService {
	private UserDao userDao;
	private SignUpService signUpService;

	public AuthManager(UserDao userDao, SignUpService signUpService) {
		//super();
		this.userDao = userDao;
		this.signUpService = signUpService;
	}

	@Override
	public void login(String email, String password) {
		if(this.userDao.get(u -> u.getEmail() == email && u.getPassword() == password) != null) {
			System.out.println(Messages.userLoggedIn);
		}else {
			System.out.println(Messages.userEmailOrPasswordNotFound);
		}
		
	}

	@Override
	public void register(User user) {
		this.signUpService.register(user);
	}

}
