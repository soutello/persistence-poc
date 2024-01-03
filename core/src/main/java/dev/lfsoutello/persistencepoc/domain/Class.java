package dev.lfsoutello.persistencepoc.domain;

import java.time.Instant;
import java.util.List;

public class Class {
    private Subject subject;
    private Instructor instructor;
    private Instant start;
    private Instant finish;
    private Instant registrationStart;
    private Instant registrationFinish;
    private Location location;
    private int maxRegistrations;
    private List<Registration> registrations;
}
