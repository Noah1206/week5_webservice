package org.webservice.assign05c0122500698;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Assign05C0122500698Application {

    public static void main(String[] args) {
        SpringApplication.run(Assign05C0122500698Application.class, args);
    }

}


//등록 → 전체 조회 → 단건 조회 → 수정
//
//→ 수정 결과 조회 → 삭제 → 삭제한 ID의 404 확인
//
//STEP 5의 기능도 테스트합니다.
//
//        A: 정상 입력과 잘못된 입력 비교
//B: 조건에 맞는 데이터와 맞지 않는 데이터의 조회 결과 비교