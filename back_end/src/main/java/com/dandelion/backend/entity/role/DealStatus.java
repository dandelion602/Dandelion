package com.dandelion.backend.entity.role;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum DealStatus {

    ON_SALE("판매중"),
    AWAITING_STOCK("물건 등록 대기중"),
    CANCELED("판매 취소"),
    IN_STOCK("물건 등록 완료"),
    PICK_UP_COMPLETE("픽업 거래 완료"),
    BIRD_MATCHING("버드 픽업 대기"),
    BIRD_MATCHED("버드 배송중"),
    BIRD_COMPLETE("버드 거래완료");

    private String value;
}
