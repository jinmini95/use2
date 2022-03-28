package use.lecture.controller;

import java.awt.Window;
import java.sql.Date;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import use.lecture.model.LectureModel;
import use.lecture.service.LectureServiceI;
import use.user.model.UserModel;

@Controller
@RequestMapping("/lectureController")
public class LectureController {
	private LectureServiceI lectureService;

	@Autowired
	public LectureController(LectureServiceI lectureService) {
		this.lectureService = lectureService;
	}

	@RequestMapping("/viewAll")
	public ModelAndView viewAll() {

		List<LectureModel> list = lectureService.viewAll();
		ModelAndView mv = new ModelAndView("NoticeList", "list", list);
		return mv;
	}

	@RequestMapping("/viewDetail")
	public ModelAndView viewDetail(@RequestParam("noticeId") String noticeId) {

		LectureModel model = lectureService.viewDetail(noticeId);
		ModelAndView mv = new ModelAndView("NoticeDetail", "model", model);
		return mv;
	}

	@GetMapping(value = "/getNoticeList")
	@ResponseBody
	public List<LectureModel> getNoticeList(@RequestParam("num") int num) {
		List<LectureModel> um;
		um = lectureService.getNoticeList((num*5));
		System.out.println(um);
		for(LectureModel lm : um) 
		{
			System.out.println(lm.getCreateDate());
		}
		return um;
	}
	
	@RequestMapping("/noticeWrite")
	public ModelAndView noticeWrite(HttpSession session) {

		//LectureModel model = lectureService.viewDetail(noticeId);
		//ModelAndView mv = new ModelAndView("NoticeDetail", "model", model);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("NoticeWrite");
		mv.addObject("userId", session.getAttribute("userId"));
		mv.addObject("userName", session.getAttribute("userName"));
		System.out.print("세션"+session.getAttribute("userId"));
		return mv;
	}
	
	@PostMapping(value = "/insertNotice", produces = "application/text; charset=UTF-8")
	@ResponseBody
	public String insertNotice(@RequestParam("userId") String userId, @RequestParam("title") String title, @RequestParam("content") String content) {
		
		LectureModel sendNotice = new LectureModel();
		String notice_id = UUID.randomUUID().toString();
		LocalDateTime dt =  LocalDateTime.now();
		sendNotice.setNoticeId(notice_id);
		sendNotice.setUserId(userId);
		sendNotice.setTitle(title);
		sendNotice.setContent(content);
		  
		int i = lectureService.insertNotice(sendNotice);
		System.out.println(i);
		return "입력완료.";

	}

}
