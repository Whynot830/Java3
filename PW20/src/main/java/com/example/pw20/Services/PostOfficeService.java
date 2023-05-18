package com.example.pw20.Services;

import com.example.pw20.Repos.PostOfficeRepo;
import com.example.pw20.Tables.PostOffice;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class PostOfficeService implements TableService<PostOffice> {
    private PostOfficeRepo postOfficeRepo;

    @Autowired
    PostOfficeService(PostOfficeRepo postOfficeRepo) {
        this.postOfficeRepo = postOfficeRepo;
    }

    @Override
    public void createEntity(PostOffice postOffice) {
        log.info("Create post office {}", postOffice);
        postOfficeRepo.save(postOffice);
    }

    @Override
    public List<PostOffice> readAllEntity() {
        log.info("Read all post offices");
        return postOfficeRepo.findAll();
    }

    @Override
    public Optional<PostOffice> readOneEntity(Long id) {
        log.info("Read one post office, id: {}", id);
        return postOfficeRepo.findById(id);
    }

    @Override
    public boolean updateEntity(PostOffice postOffice, Long id) {
        log.info("Update post office, id: {}, new post office: {}", id, postOffice);
        Optional<PostOffice> optionalPostOffice = postOfficeRepo.findById(id);
        if (optionalPostOffice.isPresent()) {
            postOffice.setId(optionalPostOffice.get().getId());
            postOfficeRepo.save(postOffice);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteEntity(Long id) {
        log.info("Delete post office, id: {}", id);
        if (postOfficeRepo.findById(id).isEmpty())
            return false;
        postOfficeRepo.deleteById(id);
        return true;
    }

    public List<PostOffice> readSortedByCityName() {
        log.info("Read all post offices, sorted by city name");
        return postOfficeRepo.findAll(Sort.by("cityName"));
    }

    public List<PostOffice> filterByCityName(String cityName) {
        log.info("Filter offices by city name: {}", cityName);
        return postOfficeRepo.findAllByCityName(cityName);
    }

}
