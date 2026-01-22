package com.itshaala.habit_builder.repository;

import com.itshaala.habit_builder.model.Habit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HabitDao extends JpaRepository<Habit,Long> {
}
