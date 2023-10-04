package net.dabbit.skd21.exam.mapper;

import net.dabbit.skd21.exam.entity.Classes;
import net.dabbit.skd21.exam.entity.Major;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ClassMapper {

    List<Classes> getByMajorId(Integer majorId);

    List<Major> getByFacultyId(Integer facultyId);

    List<Major> getAllFaculty();
}
