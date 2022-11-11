package com.javassem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javassem.domain.BoardVO;
import com.javassem.service.BoardService;

@Controller
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	@RequestMapping("getBoardList")
	public void getBoardList(Model m) { // 해당 인자에 데이터를 담아서 
		List<BoardVO> list = boardService.getBoardList();
		m.addAttribute("boardList",list);
	}
	
	@RequestMapping("insertBoard.do")
	public void insertBoard() {
		
	}
	// 폼 입력 후 새글작성
	@RequestMapping("saveBoard.do")
	public String saveBoard(BoardVO boardVO){
		//System.out.println(boardVO.getTitle());
		boardService.insertBoard(boardVO);		// 목록에 입력한 데이터 저장 됨.
		return "redirect:getBoardList.do";
	
		
	}
	
	@RequestMapping("getBoard.do")
		// BoardVO boardVO 으로 데이터를 가져와서 Model m 으로 데이터를 내보냄
	public void updateBoard(BoardVO boardVO,Model m) {
		m.addAttribute("board",boardService.getBoard(boardVO));
				// name = 테이블 value 값에 board.OO 되어있으므로 board로 적용
	}
	
	// 삭제
	@RequestMapping("deleteBoard.do")
	public void deleteBoard(BoardVO boardVO) {
		boardService.deleteBoard(boardVO);
	
	}
	
	// 수정
	@RequestMapping("updateBoard.do")
	public void modify(BoardVO boardVO) {
		boardService.updateBoard(boardVO);
	}
	
	
	
	
	
	
	

}
