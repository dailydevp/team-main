package org.zerock.service;

import java.util.List;

import org.zerock.domain.Criteria;
import org.zerock.domain.ReplyVO;

public interface ReplyService {

	public int write(ReplyVO vo);
	
	public ReplyVO get(long rno);
	
	public int modify(ReplyVO vo);
	
	public int remove(long rno);
	

	public List<ReplyVO> getList(Long bno);
	
}
