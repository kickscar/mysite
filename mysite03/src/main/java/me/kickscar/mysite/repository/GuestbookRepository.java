package me.kickscar.mysite.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.ibatis.session.SqlSession;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.*;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

import me.kickscar.mysite.vo.GuestbookVo;

@Repository
public class GuestbookRepository extends NamedParameterJdbcDaoSupport {
	private final Map<String, String> SQL = Map.of(
		"findAll",
			"select no, name, date_format(reg_date, '%Y/%m/%d %H:%i:%s') as reg_date, message from guestbook order by reg_date desc",
		"insert",
			"insert into guestbook values (null, :name, :password, :message, now())",
		"delete",
			"delete from guestbook where no=:no and password=:password"
	);

	private final SqlSession sqlSession;

	public GuestbookRepository(JdbcTemplate jdbcTemplate, SqlSession sqlSession) {
		setJdbcTemplate(jdbcTemplate);
		this.sqlSession = sqlSession;
	}

	public List<GuestbookVo> findAll() {
		return getJdbcTemplate().query(SQL.get("findAll"), (resultSet, rowNumber) -> {
			GuestbookVo vo = new GuestbookVo();
			vo.setNo(resultSet.getLong(1));
			vo.setName(resultSet.getString(2));
			vo.setRegDate(resultSet.getString(3));
			vo.setMessage(resultSet.getString(4));

			return vo;
		});
	}

	public List<GuestbookVo> findAll(Long no) {
		return sqlSession.selectList("guestbook.findAllByNo", no);
	}

	public Integer insert(GuestbookVo vo) {
		return getNamedParameterJdbcTemplate().update(SQL.get("insert"), new ObjectMapper().convertValue(vo, Map.class));
	}
	
	public Integer delete(GuestbookVo vo) {
		return getNamedParameterJdbcTemplate().update(SQL.get("delete"), new BeanPropertySqlParameterSource(vo));
	}
}