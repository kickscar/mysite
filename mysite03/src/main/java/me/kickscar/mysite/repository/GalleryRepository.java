package me.kickscar.mysite.repository;

import java.util.List;

import me.kickscar.mysite.vo.GalleryVo;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class GalleryRepository {
	@Autowired
	private SqlSession sqlSession;

	public Integer insert(GalleryVo vo) {
		return sqlSession.insert("gallery.insert", vo);
	}

	public Integer delete(Long no) {
		return sqlSession.delete("gallery.delete", no);
	}

	public List<GalleryVo> findAll() {
		return sqlSession.selectList("gallery.findAll");
	}
}
