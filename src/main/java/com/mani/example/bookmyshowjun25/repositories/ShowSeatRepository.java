package com.mani.example.bookmyshowjun25.repositories;

import com.mani.example.bookmyshowjun25.models.ShowSeat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ShowSeatRepository extends JpaRepository<ShowSeat, Long>{
    //select * from show_seat where id IN (1 4 5 7 19 ...)
    List<ShowSeat> findByIdIn(List<Long> showSeatIds);
}

