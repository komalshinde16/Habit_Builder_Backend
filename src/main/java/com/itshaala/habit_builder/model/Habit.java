package com.itshaala.habit_builder.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;


@Getter
@Setter
@Entity
public class Habit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private int streak;
    private LocalDate lastCompletedDate;

    public Habit() {}

    public Habit(String name) {
        this.name = name;
        this.streak = 0;
    }


    public Long getId() { return id; }
    public String getName() { return name; }
    public int getStreak() { return streak; }
    public LocalDate getLastCompletedDate() { return lastCompletedDate; }

    public void setName(String name) { this.name = name; }
    public void setStreak(int streak) { this.streak = streak; }
    public void setLastCompletedDate(LocalDate date) { this.lastCompletedDate = date; }
}





















