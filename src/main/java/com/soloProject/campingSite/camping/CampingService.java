package com.soloProject.campingSite.camping;

import com.soloProject.campingSite.local.Local;
import com.soloProject.campingSite.local.LocalService;
import jakarta.validation.constraints.NotEmpty;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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

    public Camping create(String campingName, String address, Long amount, Long personnel, String description, Long localId) {
        Camping camping = new Camping();
        camping.setCampingName(campingName);
        camping.setAddress(address);
        camping.setAmount(amount);
        camping.setPersonnel(personnel);
        camping.setDescription(description);

        Local local = localService.getLocal(localId);

        camping.setLocal(local);

        return campingRepository.save(camping);
    }
}
