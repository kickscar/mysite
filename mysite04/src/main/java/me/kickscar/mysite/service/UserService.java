package me.kickscar.mysite.service;

import me.kickscar.mysite.repository.UserRepository;
import me.kickscar.mysite.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;

	public void join(UserVo vo) {
		userRepository.insert(vo);
	}

	public UserVo getUser(String email, String password) {
		return userRepository.findByEmailAndPassword(email, password);
	}

	public UserVo getUser(Long no) {
		return userRepository.findByNo(no);
	}

	public UserVo getUser(String email) {
		return userRepository.findByEmail(email);
	}

	public void updateUser(UserVo userVo) {
		userRepository.update(userVo);
	}

}
