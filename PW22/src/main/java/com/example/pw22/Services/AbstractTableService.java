package com.example.pw22.Services;

import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public abstract class AbstractTableService<T> implements TableService<T> {
//    public AbstractTableService(JpaRepository<T, Long> repo) {
//        this.repo = repo;
//    }
    private final JpaRepository<T, Long> repo;
    @Transactional
    @Override
    public void createEntity(T t) {
        repo.save(t);
    }
    @Transactional(readOnly = true)
    @Override
    public List<T> readAllEntity() {
        return repo.findAll();
    }
    @Transactional(readOnly = true)
    @Override
    public Optional<T> readOneEntity(Long id) {
        return repo.findById(id);
    }
//    @Transactional
//    @Override
//    public boolean updateEntity(T t, Long id) {
//        Optional<T> optionalT = repo.findById(id);
//        if (optionalT.isPresent()) {
//            t.setId(optionalT.get().getId());
//            repo.save(t);
//            return true;
//        }
//        return false;
//    }
    @Transactional
    @Override
    public boolean deleteEntity(Long id) {
        if (repo.findById(id).isEmpty())
            return false;
        repo.deleteById(id);
        return true;
    }
}
