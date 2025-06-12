package com.mani.example.bookmyshowjun25.repositories;

import com.mani.example.bookmyshowjun25.models.Show;
import com.mani.example.bookmyshowjun25.models.ShowSeatType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ShowSeatTypeRepository extends JpaRepository<ShowSeatType,Long> {
    /*
    123 GOLD 500
    123 SILVER 300  
    123 PLATINUM 700
    123 RECLINER 800
     */
    List<ShowSeatType> findAllByShow(Show show);

    Show show(Show show);
}
