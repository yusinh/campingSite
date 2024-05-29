package com.soloProject.campingSite.local;

import com.soloProject.campingSite.camping.Camping;
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

    public Local getLocal(Long localId) {
        return localRepository.findById(localId).orElseThrow();
    }
}
