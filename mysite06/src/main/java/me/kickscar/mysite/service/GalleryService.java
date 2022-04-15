package me.kickscar.mysite.service;

import java.util.List;

import me.kickscar.mysite.repository.GalleryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import me.kickscar.mysite.vo.GalleryVo;

@Service
public class GalleryService {
	@Autowired
	private GalleryRepository galleryRepository;

	public List<GalleryVo> getImages() {
		return galleryRepository.findAll();
	}
	
	public Boolean removeImage(Long no) {
		return galleryRepository.delete(no);
	}
	
	public Boolean saveImage(GalleryVo vo) {
		return galleryRepository.insert(vo);
	}
}
