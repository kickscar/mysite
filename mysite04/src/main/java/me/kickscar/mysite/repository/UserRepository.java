package me.kickscar.mysite.repository;

import me.kickscar.mysite.vo.UserVo;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class UserRepository {
	@Autowired
	private SqlSession sqlSession;
	
	public Integer insert(UserVo vo) {
		return sqlSession.insert("user.insert", vo);
	}

	public UserVo findByEmailAndPassword(String email, String password) {
		Map<String, String> map = new HashMap<>();
		map.put("e", email);
		map.put("p", password);
		return sqlSession.selectOne("user.findByEmailAndPassword", map);
	}

	public UserVo findByNo(Long no) {
		return sqlSession.selectOne("user.findByNo", no);
	}

	public UserVo findByEmail(String email) {
		return sqlSession.selectOne("user.findByEmail", email);
	}	

	public Integer update(UserVo userVo) {
		return sqlSession.update("user.update", userVo);
	}
}
