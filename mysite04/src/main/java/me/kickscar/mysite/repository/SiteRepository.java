package me.kickscar.mysite.repository;

import me.kickscar.mysite.vo.SiteVo;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class SiteRepository {
	@Autowired
	private SqlSession sqlSession;

	public SiteVo find() {
		return sqlSession.selectOne("site.find");
	}
	
	public void update(SiteVo vo) {
		sqlSession.update("site.update", vo);
	}
}
