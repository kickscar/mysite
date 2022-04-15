package me.kickscar.mysite.repository;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import me.kickscar.mysite.exception.GuestbookRepositoryException;
import me.kickscar.mysite.vo.GuestbookVo;

@Repository
public class GuestbookRepository {
	@Autowired
	private SqlSession sqlSession;
	
	public List<GuestbookVo> findAll() throws GuestbookRepositoryException {
		return sqlSession.selectList("guestbook.findAll");
	}
	
	public Integer delete(GuestbookVo vo) {
		return sqlSession.delete("guestbook.delete", vo);
	}
	
	public Integer insert(GuestbookVo vo) {
		return sqlSession.insert("guestbook.insert", vo);
	}
}