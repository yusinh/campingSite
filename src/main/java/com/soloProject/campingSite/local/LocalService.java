package com.soloProject.campingSite.local;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LocalService {

    private final LocalRepository localRepository;

    public List<Local> getLocalList() {

        return localRepository.findAll();
    }
}
