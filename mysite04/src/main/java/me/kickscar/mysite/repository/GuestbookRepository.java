package me.kickscar.mysite.repository;

import me.kickscar.mysite.vo.GuestbookVo;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class GuestbookRepository {
	private final SqlSession sqlSession;

	public GuestbookRepository(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	public List<GuestbookVo> findAll() {
		return sqlSession.selectList("guestbook.findAll");
	}

	public List<GuestbookVo> findAll(Long no) {
		return sqlSession.selectList("guestbook.findAllByNo", no);
	}

	public Integer insert(GuestbookVo vo) {
		return sqlSession.insert("guestbook.insert", vo);
	}
	
	public Integer delete(GuestbookVo vo) {
		return sqlSession.delete("guestbook.delete", vo);
	}
}