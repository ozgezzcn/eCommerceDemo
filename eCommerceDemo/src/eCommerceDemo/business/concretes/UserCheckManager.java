package eCommerceDemo.business.concretes;

import eCommerceDemo.business.abstracts.UserCheckService;
import eCommerceDemo.core.utils.RunTools;
import eCommerceDemo.core.utils.consts.Messages;
import eCommerceDemo.core.utils.results.ErrorResult;
import eCommerceDemo.core.utils.results.ResultBase;
import eCommerceDemo.core.utils.results.SuccessResult;
import eCommerceDemo.dataAccess.abstracts.UserDao;
import eCommerceDemo.entities.concretes.User;

public class UserCheckManager implements UserCheckService  {
	private UserDao userDao;
	
	
	public UserCheckManager(UserDao userDao) {
		this.userDao = userDao;
	}
	
	
	@Override
	public void check(User user) throws Exception {
		ResultBase[] results = RunTools.runChecks(this.checkDuplicateEmail(user.getEmail()));
		
		for(ResultBase result : results)
		{
			if(!result.isSuccess())
			{
				throw new Exception(result.getMessage());
			}
		}
		
	}
	
	private ResultBase checkDuplicateEmail(String email) {
		if(this.userDao.get(u -> u.getEmail() == email) != null)
		{
			return new ErrorResult(Messages.emailAlreadyExists);
		}
		return new SuccessResult();
	}
	

}
