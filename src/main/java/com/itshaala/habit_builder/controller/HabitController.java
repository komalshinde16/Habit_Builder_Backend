package com.itshaala.habit_builder.controller;

import com.itshaala.habit_builder.model.Habit;
import com.itshaala.habit_builder.service.HabitService;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
@RequestMapping("/habits")
@CrossOrigin(origins = "*")

public class HabitController {
    private final HabitService habitService;

    public HabitController(HabitService habitService) {
        this.habitService = habitService;
    }

    @PostMapping
    public Habit addHabit(@RequestBody Habit habit) {
        return habitService.addHabit(habit);
    }

    @GetMapping
    public List<Habit> getHabits() {
        return habitService.getAllHabits();
    }

    @PutMapping("/{id}/done")
    public Habit markHabitDone(@PathVariable Long id) {
        return habitService.markDone(id);
    }

    @PutMapping("/{id}")
    public Habit updateHabit(@PathVariable Long id, @RequestBody Habit habit) {
        return habitService.updateHabit(id, habit);
    }























}
