package lk.ijse.gdse.springdeployment.controller;

import lk.ijse.gdse.springdeployment.dto.JobDto;
import lk.ijse.gdse.springdeployment.service.JobService;
import lk.ijse.gdse.springdeployment.utill.ApiResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/job")
@RequiredArgsConstructor
public class JobController {

    private final JobService jobService;

    @PostMapping("create")
    public ResponseEntity<ApiResponse> createJob( @RequestBody JobDto jobDto) {
        jobService.saveJob(jobDto);
        return new ResponseEntity(
            new ApiResponse(
                    200 ,
                    "job create Success" ,
                    null
            ), HttpStatus.OK
        );
    }

    @PutMapping("update")
    public ResponseEntity<ApiResponse> updateJob( @RequestBody JobDto jobDto) {
        jobService.updateJob(jobDto);
        return new ResponseEntity(
            new ApiResponse(
                    200 ,
                    "job update Success" ,
                    null
            ), HttpStatus.OK
        );
    }

    @GetMapping("get")
    public ResponseEntity<ApiResponse> getAllJobs(){
        List<JobDto> jobDtos = jobService.getJobs();
        return new ResponseEntity(
                new ApiResponse(
                        200 ,
                        "job Get Success" ,
                        jobDtos
                ), HttpStatus.OK
        );
    }

    @DeleteMapping("delete")
    public ResponseEntity<ApiResponse> deleteJob(@RequestParam Integer id){
        jobService.delete(id);
        return new ResponseEntity(
            new ApiResponse(
                    200 ,
                    "job delete Success" ,
                    null
            ), HttpStatus.OK
        );
    }

    @PatchMapping("status/{name}")
    public ResponseEntity<ApiResponse> changeStatus(@PathVariable("name") String id){
        jobService.changeStatus(id);
        return ResponseEntity.ok(
            new ApiResponse(
                    200,
                    "job change Status update",
                    null
            )
        );
    }

    @GetMapping("search/{keyword}")
    public ResponseEntity<ApiResponse> searchJob(@PathVariable("keyword") String keyword) {
        List<JobDto>jobDtos =  jobService.searchJob(keyword);
        return ResponseEntity.ok(
            new ApiResponse(
                    200,
                    "Job found Successfully",
                    jobDtos
            )
        );
    }

    @GetMapping("paginated")
    public List<JobDto> getPaginatedJobs(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "5") int size) {
        return jobService.getJobsByPage(page, size);
    }

    @GetMapping("total-pages")
    public int getTotalPages(@RequestParam(defaultValue = "5") int size) {
        return jobService.getTotalPages(size);
    }
}
