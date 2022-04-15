package me.kickscar.mysite.repository;

import java.util.List;

import me.kickscar.mysite.vo.GuestbookVo;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class GuestbookRepository {
	@Autowired
	private SqlSession sqlSession;
	
	public List<GuestbookVo> findAll() {
		return sqlSession.selectList("guestbook.findAll");
	}

	public Integer insert(GuestbookVo vo) {
		return sqlSession.insert("guestbook.insert", vo);
	}
	
	public Integer delete(GuestbookVo vo) {
		return sqlSession.delete("guestbook.delete", vo);
	}
}