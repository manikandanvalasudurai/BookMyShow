package com.mani.example.bookmyshowjun25.dtos;

import java.util.List;

public class CreateBookingRequestDto {
    private List<Long> showSeatIds;
    private Long userId;

    public List<Long> getShowSeatIds() {
        return showSeatIds;
    }

    public void setShowSeatIds(List<Long> showSeatIds) {
        this.showSeatIds = showSeatIds;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
