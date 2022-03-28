package use.lecture.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import use.lecture.dao.LectureMapper;
import use.lecture.model.LectureModel;
import use.user.model.UserModel;

@Service
public class LectureServiceImpl implements LectureServiceI {

	
	public LectureMapper lectureMapper;
	@Autowired
	public LectureServiceImpl(LectureMapper lectureMapper) { this.lectureMapper= lectureMapper; }
	@Override
	public List<LectureModel> viewAll() {
		List<LectureModel> mol = lectureMapper.viewAll();
		System.out.println("impl"+mol.size());
		return mol;
		
	}
	@Override
	public LectureModel viewDetail(String noticeId) {
		LectureModel mol = lectureMapper.viewDetail(noticeId);
		return mol;
	}
	@Override
	public List<LectureModel> getNoticeList(int num) {
		List<LectureModel> mol = lectureMapper.getNoticeList(num);
		return mol;
	}
	@Override
	public int insertNotice(LectureModel notice) {
		return lectureMapper.insertNotice(notice);
	}
}
