package me.kickscar.mysite.controller.api;

import me.kickscar.mysite.dto.JsonResult;
import me.kickscar.mysite.vo.GuestbookVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import me.kickscar.mysite.service.GuestbookService;

import java.util.List;

@RestController("guestbookControllerApi")
@RequestMapping("/guestbook/api")
public class GuestbookController {
	@Autowired
	private GuestbookService guestbookService;

	@GetMapping("/list/{no}")
	public JsonResult list(@PathVariable("no") Long startNo) {
		List<GuestbookVo> list = guestbookService.getMessageList(startNo);
		return JsonResult.success(list);
	}

	@PostMapping("/add")
	public JsonResult add(@RequestBody GuestbookVo vo) {
		guestbookService.addMessage(vo);
		vo.setPassword("");
		return JsonResult.success(vo);
	}

	@DeleteMapping("/delete/{no}")
	public JsonResult delete(@PathVariable("no") Long no, @RequestParam(value="password", required=true, defaultValue="") String password) {
		boolean result = guestbookService.deleteMessage(no, password);
		return JsonResult.success(result ? no : -1);
	}
}