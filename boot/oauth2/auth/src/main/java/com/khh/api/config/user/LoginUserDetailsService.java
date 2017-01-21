package com.khh.api.config.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


//@Transactional //http://jdm.kr/blog/141
@Service
public class LoginUserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService{
	@Autowired
	MessageSourceAccessor messageSource;

	@Autowired
	LoginUserRepository userRepository;

	@Override
	public LoginUserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		LoginUserDetails userDetails = userRepository.findByUsername(username);
		if (null == userDetails) {
			throw new UsernameNotFoundException(messageSource.getMessage("error.login.fail"));
		}
		return userDetails;
	}
}
