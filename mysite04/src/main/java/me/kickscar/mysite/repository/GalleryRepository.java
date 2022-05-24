package me.kickscar.mysite.repository;

import me.kickscar.mysite.vo.GalleryVo;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

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
