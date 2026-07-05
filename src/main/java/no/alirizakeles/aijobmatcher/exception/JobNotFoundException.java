package no.alirizakeles.aijobmatcher.exception;

public class JobNotFoundException extends RuntimeException {

    public JobNotFoundException(Long id) {
        super("Job with id " + id + " was not found");
    }
}