package lk.ijse.gdse.springdeployment.service.impl;

import lk.ijse.gdse.springdeployment.dto.JobDto;
import lk.ijse.gdse.springdeployment.entity.Job;
import lk.ijse.gdse.springdeployment.exception.DeleteExistNotFoundException;
import lk.ijse.gdse.springdeployment.exception.ExistNotFoundException;
import lk.ijse.gdse.springdeployment.exception.ResourceNotFoundException;
import lk.ijse.gdse.springdeployment.exception.UpdateExistNotFoundException;
import lk.ijse.gdse.springdeployment.repositary.JobRepositry;
import lk.ijse.gdse.springdeployment.service.JobService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:63343")
public class JobServiceImpl implements JobService {

    private final JobRepositry jobRepositry;
    private final ModelMapper modelMapper;

    @Override
    public void saveJob(JobDto jobDto) {
        if (jobDto.getId() != null && jobRepositry.existsById(jobDto.getId())) {
            throw new ExistNotFoundException("Job already exists");
        }
        jobRepositry.save(modelMapper.map(jobDto, Job.class));
    }


    @Override
    public void updateJob(JobDto jobDto) {
        if (jobRepositry.existsById(jobDto.getId())) {
            throw new ResourceNotFoundException("Job does not exist to update");
        }
    }

    @Override
    public List<JobDto> getJobs() {
        List<Job>allJobs = jobRepositry.findAll();
        List<JobDto> jobDtos = new ArrayList<>();
        if (allJobs.isEmpty()){
            throw new ResourceNotFoundException("No Jobs found");
        }
        for (Job job : allJobs) {
            jobDtos.add(modelMapper.map(job, JobDto.class));
        }
        return jobDtos;
    }

    @Override
    public void changeStatus(String id) {
        if (jobRepositry.existsById(Integer.valueOf(id))){
            throw new UpdateExistNotFoundException("job is Exists");
        }
        jobRepositry.updateStauts(id);
    }

    @Override
    public List<JobDto> searchJob(String keyword) {
        List<Job>list=jobRepositry.findJobByJobTitleContainingIgnoreCase(keyword);

        return modelMapper.map(list, new TypeToken<List<JobDto>>(){}.getType());
    }

    @Override
    public void delete(Integer id) {
        if (jobRepositry.existsById(id)){
            throw new DeleteExistNotFoundException("job is Exist");
        }
        jobRepositry.deleteById(id);
    }

    @Override
    public List<JobDto> getJobsByPage(int page, int size) {
        int offset = page * size;
        List<Job> jobs = jobRepositry.findJobsPaginated(size, offset);
        return modelMapper.map(jobs, new TypeToken<List<JobDto>>() {}.getType());
    }

    @Override
    public int getTotalPages(int size) {
        int totalJobs = jobRepositry.getTotalJobCount();
        return (int) Math.ceil((double) totalJobs / size);
    }
}
