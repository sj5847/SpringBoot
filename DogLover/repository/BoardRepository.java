package com.LoversDogs.Lovers.repository;

import com.LoversDogs.Lovers.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;




public interface BoardRepository extends JpaRepository<Board, String> {

}
