package lk.ijse.gdse.springdeployment.service;

import lk.ijse.gdse.springdeployment.dto.JobDto;

import java.util.List;

public interface JobService {
    void saveJob(JobDto jobDto);
    void updateJob(JobDto jobDto);
    List<JobDto> getJobs();
    void changeStatus(String id);
    List<JobDto> searchJob(String keyword);
    void delete(Integer id);
    List<JobDto> getJobsByPage(int page, int size);
    int getTotalPages(int size);
}
