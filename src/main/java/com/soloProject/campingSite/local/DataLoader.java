package com.soloProject.campingSite.local;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private LocalRepository localRepository;

    @Override
    public void run(String... args) throws Exception {
        // 데이터베이스에 기존 데이터가 있는지 확인
        List<Local> existingLocals = localRepository.findAll();

        // 데이터가 없는 경우에만 새로운 데이터 추가
        if (existingLocals.isEmpty()) {
            localRepository.save(new Local("서울"));
            localRepository.save(new Local("대전"));
            localRepository.save(new Local("인천"));
            localRepository.save(new Local("대구"));
            localRepository.save(new Local("광주"));
            localRepository.save(new Local("울산"));
            localRepository.save(new Local("부산"));
            localRepository.save(new Local("경기도"));
            localRepository.save(new Local("충청도"));
            localRepository.save(new Local("강원도"));
            localRepository.save(new Local("경상도"));
            localRepository.save(new Local("전라도"));
            localRepository.save(new Local("제주도"));
        }
    }
}