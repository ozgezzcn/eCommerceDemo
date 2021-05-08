package eCommerceDemo.business.concretes;

import java.util.UUID;

import eCommerceDemo.business.abstracts.UserActivationService;
import eCommerceDemo.core.services.MailService;
import eCommerceDemo.core.utils.consts.Environment;
import eCommerceDemo.core.utils.consts.Messages;
import eCommerceDemo.dataAccess.abstracts.UserActivationDao;
import eCommerceDemo.dataAccess.abstracts.UserDao;
import eCommerceDemo.entities.concretes.User;
import eCommerceDemo.entities.concretes.UserActivation;

public class UserActivationManager implements UserActivationService {
	 private UserDao userDao;
	 private UserActivationDao userActivationDao;
	 private MailService mailService;
	 
 public UserActivationManager(UserDao userDao, UserActivationDao userActivationDao, MailService mailService) {	
			this.userDao = userDao;
			this.userActivationDao = userActivationDao;
			this.mailService = mailService;
		}
 

	@Override
	public void activate(String activationCode) {
		UserActivation userActivation = this.userActivationDao.get(u -> u.getActivationCode() == activationCode);
		if(userActivation != null)
		{
			int userId = userActivation.getUserId();
			User user = this.userDao.get(u -> u.getId() == userId);
			user.setActive(true);
			this.userDao.update(user);
			System.out.println(Messages.userActivated);
		}
		else 
		{
			System.out.println(Messages.activationCodeNotFound);
		}
		
	}

	@Override
	public void add(User user) {
		UUID uuid = UUID.randomUUID();
		String activationCode = uuid.toString();
		this.userActivationDao.add(new UserActivation(1, user.getId(), activationCode));
		this.mailService.sendMail(user.getEmail(), Environment.url + Environment.activationPath + activationCode);
	}

}
