package com.example.passwordmanager.service;

import com.example.passwordmanager.model.PasswordEntry;
import com.example.passwordmanager.repository.PasswordEntryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PasswordEntryService {

    private final PasswordEntryRepository repository;

    public PasswordEntryService(PasswordEntryRepository repository) {
        this.repository = repository;
    }

    public List<PasswordEntry> getAll() {
        return repository.findAll();
    }

    public PasswordEntry save(PasswordEntry entry) {
        return repository.save(entry);
    }

    public Optional<PasswordEntry> getById(Long id) {
        return repository.findById(id);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
