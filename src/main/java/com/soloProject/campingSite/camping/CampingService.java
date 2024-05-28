package com.soloProject.campingSite.camping;

import com.soloProject.campingSite.local.Local;
import com.soloProject.campingSite.local.LocalService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class CampingService {

    private final CampingRepository campingRepository;
    private final LocalService localService;

    public Camping getCamping(Long localId) {
        return campingRepository.findById(localId).orElseThrow();
    }

    public void save(Camping camping) {
        campingRepository.save(camping);
    }

    public void create(String campingName, String address, Integer amount, Integer personnel) {
        Camping camping = new Camping();
        camping.setCampingName(campingName);
        camping.setAddress(address);
        camping.setAmount(amount);
        camping.setPersonnel(personnel);
        campingRepository.save(camping);
    }
}
