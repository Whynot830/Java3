package com.example.pw18.Services;

import com.example.pw18.Repos.PostOfficeRepo;
import com.example.pw18.Tables.PostOffice;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PostOfficeService implements TableService<PostOffice> {
    private PostOfficeRepo postOfficeRepo;

    @Autowired
    PostOfficeService(PostOfficeRepo postOfficeRepo) {
        this.postOfficeRepo = postOfficeRepo;
    }

    @Override
    public void createEntity(PostOffice postOffice) {
        postOfficeRepo.save(postOffice);
    }

    @Override
    public List<PostOffice> readAllEntity() {
        return postOfficeRepo.findAll();
    }

    @Override
    public Optional<PostOffice> readOneEntity(Long id) {
        return postOfficeRepo.findById(id);
    }

    @Override
    public boolean updateEntity(PostOffice postOffice, Long id) {
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
        if (postOfficeRepo.findById(id).isEmpty())
            return false;
        postOfficeRepo.deleteById(id);
        return true;
    }

    public List<PostOffice> readSortedByCityName() {
        return postOfficeRepo.findAll(Sort.by("cityName"));
    }

    public List<PostOffice> filterByCityName(String cityName) {
        return postOfficeRepo.findAllByCityName(cityName);
    }

}
