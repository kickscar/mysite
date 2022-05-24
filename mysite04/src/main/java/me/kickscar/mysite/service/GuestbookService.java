package me.kickscar.mysite.service;

import me.kickscar.mysite.repository.GuestbookRepository;
import me.kickscar.mysite.vo.GuestbookVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GuestbookService {
	@Autowired
	GuestbookRepository guestbookRepository;
	
	public List<GuestbookVo> getMessageList() {
			return guestbookRepository.findAll();
	}
	
	public List<GuestbookVo> getMessageList(Long no) {
		return guestbookRepository.findAll(no);
	}
	
	public Boolean deleteMessage(Long no, String password) {
		GuestbookVo vo = new GuestbookVo();
		vo.setNo(no);
		vo.setPassword(password);
		
		return guestbookRepository.delete(vo).equals(1);
	}

	public Boolean addMessage(GuestbookVo vo) {
		return guestbookRepository.insert(vo).equals(1);
	}
}
