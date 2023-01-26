package me.kickscar.mysite.service;

import java.util.List;

import me.kickscar.mysite.repository.GuestbookRepository;
import me.kickscar.mysite.vo.GuestbookVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GuestbookService {
	@Autowired
	GuestbookRepository guestbookRepository;
	
	public List<GuestbookVo> getMessageList() {
			return guestbookRepository.findAll();
	}
	
	public void deleteMessage(Long no, String password) {
		GuestbookVo vo = new GuestbookVo();
		vo.setNo(no);
		vo.setPassword(password);
		
		guestbookRepository.delete(vo);
	}

	public void addMessage(GuestbookVo vo) {
		guestbookRepository.insert(vo);
	}
	
}
