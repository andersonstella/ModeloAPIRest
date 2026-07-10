package taskmanager.application.input;

import java.util.Optional;

public record CreateTaskInput(String tittle, Optional<String> description) {
}
