package me.kickscar.mysite.controller;

import java.util.Map;

import me.kickscar.web.WebUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import me.kickscar.mysite.service.BoardService;
import me.kickscar.mysite.vo.BoardVo;
import me.kickscar.mysite.vo.UserVo;
import me.kickscar.mysite.security.Auth;
import me.kickscar.mysite.security.AuthUser;

@Controller
@RequestMapping( "/board" )
public class BoardController {
	@Autowired
	private BoardService boardService;

	@RequestMapping( "" )
	public String index(
		@RequestParam( value="p", required=true, defaultValue="1") Integer page,
		@RequestParam( value="kwd", required=true, defaultValue="") String keyword,
		Model model ) {
		
		Map<String, Object> map = boardService.getContentsList( page, keyword );
		model.addAttribute("map", map);
		//model.addAllAttributes(map);
		
		return "views/board/index";
	}
	
	@RequestMapping( "/view/{no}" )
	public String view( @PathVariable( "no" ) Long no, Model model ) {
		BoardVo boardVo = boardService.getContents( no );
		model.addAttribute( "boardVo", boardVo );
		return "views/board/view";
	}
	
	@Auth
	@RequestMapping( "/delete/{no}" )
	public String delete(
		@AuthUser UserVo authUser,	
		@PathVariable( "no" ) Long boardNo,
		@RequestParam( value="p", required=true, defaultValue="1") Integer page,
		@RequestParam( value="kwd", required=true, defaultValue="") String keyword ) {
		boardService.deleteContents( boardNo, authUser.getNo() );
		return "redirect:/board?p=" + page + "&kwd=" + WebUtil.encodeURL( keyword, "UTF-8" );
	}
	
	@Auth
	@RequestMapping( value="/modify/{no}" )	
	public String modify(
		@AuthUser UserVo authUser,
		@PathVariable( "no" ) Long no,
		Model model) {
		BoardVo boardVo = boardService.getContents(no, authUser.getNo() );
		model.addAttribute( "boardVo", boardVo );
		return "views/board/modify";
	}

	@Auth
	@RequestMapping( value="/modify", method=RequestMethod.POST )	
	public String modify(
		@AuthUser UserVo authUser,
		@ModelAttribute BoardVo boardVo,
		@RequestParam( value="p", required=true, defaultValue="1") Integer page,
		@RequestParam( value="kwd", required=true, defaultValue="") String keyword ) {
		boardVo.setUserNo( authUser.getNo() );
		boardService.modifyContents( boardVo );
		return "redirect:/board/view/" + boardVo.getNo() + 
				"?p=" + page + 
				"&kwd=" + WebUtil.encodeURL( keyword, "UTF-8" );
	}

	@Auth
	@RequestMapping( value="/write", method=RequestMethod.GET )	
	public String write() {
		return "views/board/write";
	}

	@Auth	
	@RequestMapping( value="/write", method=RequestMethod.POST )	
	public String write(
		@AuthUser UserVo authUser,
		@ModelAttribute BoardVo boardVo,
		@RequestParam( value="p", required=true, defaultValue="1") Integer page,
		@RequestParam( value="kwd", required=true, defaultValue="") String keyword ) {
		boardVo.setUserNo( authUser.getNo() );
		boardService.addContents( boardVo );
		
		return	"redirect:/board?p=" + page + "&kwd=" + WebUtil.encodeURL( keyword, "UTF-8" );
	}

	@Auth
	@RequestMapping( value="/reply/{no}" )	
	public String reply(@PathVariable( "no" ) Long no, Model model) {
		BoardVo boardVo = boardService.getContents( no );
		boardVo.setOrderNo( boardVo.getOrderNo() + 1 );
		boardVo.setDepth( boardVo.getDepth() + 1 );
		
		model.addAttribute( "boardVo", boardVo );
		
		return "views/board/reply";
	}	
}
