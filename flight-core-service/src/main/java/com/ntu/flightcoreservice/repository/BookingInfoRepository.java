package com.ntu.flightcoreservice.repository;


import com.ntu.flightcoreservice.entity.BookingInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookingInfoRepository extends JpaRepository<BookingInfo, String> {
    @Query("select bi from BookingInfo bi where bi.bookingId =:bookingId")
    public BookingInfo getBookingInfoById(@Param("bookingId") String bookingId);

    @Query("select bi from BookingInfo bi where bi.userId =:mailId")
    Optional<List<BookingInfo>> getAllBookingHistoryByUserId(@Param("mailId") String mailId);

}