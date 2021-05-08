package eCommerceDemo;

import eCommerceDemo.business.abstracts.AuthService;
import eCommerceDemo.business.abstracts.UserActivationService;
import eCommerceDemo.business.abstracts.UserCheckService;
import eCommerceDemo.business.abstracts.UserService;
import eCommerceDemo.business.abstracts.UserValidationService;
import eCommerceDemo.business.concretes.AuthManager;
import eCommerceDemo.business.concretes.UserActivationManager;
import eCommerceDemo.business.concretes.UserCheckManager;
import eCommerceDemo.business.concretes.UserManager;
import eCommerceDemo.business.concretes.UserValidationManager;
import eCommerceDemo.business.serviceAdapters.GoogleCheckServiceAdapters;
import eCommerceDemo.core.services.MailManager;
import eCommerceDemo.core.services.MailService;
import eCommerceDemo.dataAccess.abstracts.UserActivationDao;
import eCommerceDemo.dataAccess.abstracts.UserDao;
import eCommerceDemo.dataAccess.concretes.InMemoryUserActivationDao;
import eCommerceDemo.dataAccess.concretes.InMemoryUserDao;
import eCommerceDemo.entities.concretes.User;
public class Main {

	public static void main(String[] args) {
		
		UserDao userDao = new InMemoryUserDao();
		UserValidationService userValidationService = new UserValidationManager();
		UserCheckService userCheckService = (UserCheckService) new UserCheckManager(userDao);
		UserActivationDao userActivationDao = new InMemoryUserActivationDao();
		MailService mailService = new MailManager();	
		UserActivationService userActivationService = new UserActivationManager(userDao, userActivationDao, mailService);
		UserService userService = new UserManager(userDao,userValidationService,userCheckService,userActivationService);
		
		User user = new User(1, "Özge", "Özcan", "ozgezzcn@gmail.com", "123456", false);
		
		AuthService authService = new AuthManager(userDao, new GoogleCheckServiceAdapters(userService));
		authService.register(user);
		
		userActivationService.activate("");
		authService.login( "ozgezzcn@gmail.com", "123456");
	}

}
