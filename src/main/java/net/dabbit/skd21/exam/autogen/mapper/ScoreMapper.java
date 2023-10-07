package net.dabbit.skd21.exam.autogen.mapper;

import net.dabbit.skd21.exam.autogen.entity.Score;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ScoreMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Score record);

    int insertSelective(Score record);

    Score selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Score record);

    int updateByPrimaryKey(Score record);



    Score queryByUserIdAndSubjectId(int user_id,int score_id);

    List<Score> queryByUserId(int user_id);
}