package org.zerock.mapper;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.EatReplyVO;
import org.zerock.domain.travel.T_ReplyVO;
import org.zerock.mapper.travel.T_ReplyMapper;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"file:src/main/webapp/WEB-INF/spring/root-context.xml","file:src/main/webapp/WEB-INF/spring/security-context.xml"})
@Log4j
public class T_ReplyMapperTests {
	
	@Setter(onMethod_= @Autowired)
	private T_ReplyMapper mapper;
	
	@Test
	public void testMapper() {
		assertNotNull(mapper);
	}
	
	@Test
	public void testInsert() {
		T_ReplyVO vo = new T_ReplyVO();
		vo.setReply("댓글!!!");
		vo.setReplyer("태원");
		vo.setBno(1L);
		
		int cnt = mapper.insert(vo);
		assertEquals(1, cnt);
	}
	
	@Test
	public void testRead() {
		
		Long targetRno = 1L;
		
		T_ReplyVO vo = mapper.read(targetRno);
		
		log.info(vo);
	}
	
	@Test
	public void testUpdate() {
		
		Long targetRno = 1L;
		T_ReplyVO vo = mapper.read(targetRno);
		
		String re = "수정된 댓글";
		vo.setReply(re);
		
		assertEquals(1, mapper.update(vo));
		
		vo = mapper.read(targetRno);
		assertEquals(re, vo.getReply());
	}
	
	@Test
	public void testDeleteByBno() {
		Long bno = 1L;
		
		mapper.deleteByBno(bno);
	}
}




















