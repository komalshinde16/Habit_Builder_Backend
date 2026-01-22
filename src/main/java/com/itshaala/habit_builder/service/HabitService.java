package com.itshaala.habit_builder.service;


import com.itshaala.habit_builder.model.Habit;
import com.itshaala.habit_builder.repository.HabitDao;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class HabitService {

    private final HabitDao habitDao;

    public HabitService(HabitDao habitDao) {
        this.habitDao = habitDao;
    }

    public Habit addHabit(Habit habit) {
        return habitDao.save(habit);
    }
    public Habit updateHabit(Long id, Habit updatedHabit) {
        Habit habit = habitDao.findById(id).orElseThrow();

        habit.setName(updatedHabit.getName());
        return habitDao.save(habit);
    }


    public List<Habit> getAllHabits() {
        return habitDao.findAll();
    }

    public Habit markDone(Long id) {
        Habit habit = habitDao.findById(id).orElseThrow();

        LocalDate today = LocalDate.now();

        if (habit.getLastCompletedDate() == null ||
                habit.getLastCompletedDate().plusDays(1).equals(today)) {
            habit.setStreak(habit.getStreak() + 1);
        } else if (!habit.getLastCompletedDate().equals(today)) {
            habit.setStreak(1);
        }

        habit.setLastCompletedDate(today);
        return habitDao.save(habit);
    }
}
