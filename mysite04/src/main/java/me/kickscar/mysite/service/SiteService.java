package me.kickscar.mysite.service;

import me.kickscar.mysite.repository.SiteRepository;
import me.kickscar.mysite.vo.SiteVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SiteService {
	@Autowired
	private SiteRepository siteRepository;

	public SiteVo getSite() {
		return siteRepository.find();
	}
	
	public void updateSite(SiteVo vo) {
		siteRepository.update(vo);
	}
}