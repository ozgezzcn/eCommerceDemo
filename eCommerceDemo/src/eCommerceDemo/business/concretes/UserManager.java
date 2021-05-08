package eCommerceDemo.business.concretes;

import java.util.List;
import java.util.function.Predicate;

import eCommerceDemo.business.abstracts.UserActivationService;
import eCommerceDemo.business.abstracts.UserCheckService;
import eCommerceDemo.business.abstracts.UserService;
import eCommerceDemo.business.abstracts.UserValidationService;
import eCommerceDemo.core.utils.results.DataResultBase;
import eCommerceDemo.core.utils.results.ResultBase;
import eCommerceDemo.core.utils.results.SuccessDataResult;
import eCommerceDemo.core.utils.results.SuccessResult;
import eCommerceDemo.dataAccess.abstracts.UserDao;
import eCommerceDemo.entities.concretes.User;

public class UserManager implements UserService {
	UserDao userDao;
	private UserValidationService userValidationService;
	private UserCheckService userCheckService;
	private UserActivationService userActivationService;
	
	
	public UserManager(UserDao userDao, UserValidationService userValidationService, UserCheckService userCheckService,
			UserActivationService userActivationService) {
		
		this.userDao = userDao;
		this.userValidationService = userValidationService;
		this.userCheckService = userCheckService;
		this.userActivationService = userActivationService;
	}
	
	
	@Override
	public ResultBase add(User user) {
		boolean thrown = false;
		try {
			this.userValidationService.validate(user);
			this.userCheckService.check(user);
		}catch(Exception e){
			thrown = true;
			e.printStackTrace();
		}finally {
			if(!thrown) 
			{
				this.userDao.add(user);
				System.out.println("User created : " + user.toString());
				this.userActivationService.add(user);
			}
		}
		return new SuccessResult("Eklendi");
	}
	
	@Override
	public ResultBase update(User user) {
		try {
			this.userValidationService.validate(user);
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		
		this.userDao.update(user);
		return new SuccessResult("Güncellendi");
	}
	
	@Override
	public ResultBase delete(User user) {
		this.userDao.delete(user);
		return new SuccessResult("Silindi");
	}
	
	@Override
	public DataResultBase<User> get(Predicate<User> predicate) {
		return new SuccessDataResult<User>(this.userDao.get(predicate),"Kayýt baþarýyla getirildi.");
	}
	
	@Override
	public DataResultBase<List<User>> getAll() {
		return new SuccessDataResult<List<User>>(this.userDao.getAll(),"Kayýt baþarýyla getirildi.");
	}
	
	@Override
	public DataResultBase<List<User>> getAll(Predicate<User> predicate) {
		return new SuccessDataResult<List<User>>(this.userDao.getAll(predicate),"Kayýt baþarýyla getirildi.");
	}

}
