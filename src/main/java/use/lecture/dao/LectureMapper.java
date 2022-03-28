package use.lecture.dao;

import java.util.List;

import use.lecture.model.LectureModel;

public interface LectureMapper {
	public List<LectureModel> viewAll();

	public LectureModel viewDetail(String noticeId);

	public List<LectureModel> getNoticeList(int num);

	public int insertNotice(LectureModel notice);
}
