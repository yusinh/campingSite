package com.soloProject.campingSite.camping;

import com.soloProject.campingSite.local.Local;
import com.soloProject.campingSite.local.LocalService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@Service
@RequiredArgsConstructor
public class CampingService {

    private final CampingRepository campingRepository;
    private final LocalService localService;

    @Value("${file.upload-dir}")
    private String uploadDir;

    public Camping create(String campingName, String address, Long amount, Long personnel, String description, Long localId, MultipartFile photo) throws IOException {
        Camping camping = new Camping();
        camping.setCampingName(campingName);
        camping.setAddress(address);
        camping.setAmount(amount);
        camping.setPersonnel(personnel);
        camping.setDescription(description);

        Local local = localService.getLocal(localId);
        camping.setLocal(local);

        if (!photo.isEmpty()) {
            String photoName = System.currentTimeMillis() + "_" + photo.getOriginalFilename();
            String photoPath = uploadDir + photoName;

            File uploadDirFile = new File(uploadDir);
            if (!uploadDirFile.exists()) {
                Files.createDirectories(Paths.get(uploadDir));
            }

            photo.transferTo(new File(photoPath));
            camping.setPhotoUrl(photoPath);
        }

        return campingRepository.save(camping);
    }
}
