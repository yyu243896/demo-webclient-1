package com.example.demo.mapper;

import com.example.demo.service.BoardVo;
import com.example.demo.service.CommentVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {
	List<BoardVo> getList();

	List<CommentVo> getComments(long brdId);

}
