package com.example.pw23.Services;

import com.example.pw23.Tables.Departure;
import com.example.pw23.Tables.PostOffice;
import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

@Service
public class SchedulerService {
    private DepartureService departureService;
    private PostOfficeService postOfficeService;
    SchedulerService(DepartureService departureService, PostOfficeService postOfficeService) {
        this.departureService = departureService;
        this.postOfficeService = postOfficeService;
    }
    @Scheduled(cron = "0 */30 * * * *")
    public void scheduledTask() throws IOException {
        File directory = new File("backup");
        FileUtils.cleanDirectory(directory);

        List<Departure> departures = departureService.readAllEntity();
        List<PostOffice> postOffices = postOfficeService.readAllEntity();
        File departureFile = new File(directory, "departures.txt");
        File postOfficeFile = new File(directory, "post_offices.txt");

        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(departureFile));
        for (Departure departure : departures)
            bufferedWriter.write(departure + "\n");

        bufferedWriter.close();
        bufferedWriter = new BufferedWriter(new FileWriter(postOfficeFile));

        for (PostOffice postOffice : postOffices)
            bufferedWriter.write(postOffice + "\n");

        bufferedWriter.close();
    }
}
