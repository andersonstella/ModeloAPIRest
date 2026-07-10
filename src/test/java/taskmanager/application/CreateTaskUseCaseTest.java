package taskmanager.application;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import taskmanager.application.input.CreateTaskInput;
import taskmanager.application.output.TaskOutput;
import taskmanager.domain.Task;
import taskmanager.domain.TaskRepository;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CreateTaskUseCaseTest {

    @Mock
    TaskRepository repository;

    @InjectMocks
    CreateTaskUseCase useCase;

    @Test
    void should_create_task_succesfully() {
        //given
        var input = new CreateTaskInput("Estudar java", Optional.of("Finalizar"));

        when(repository.save(any(Task.class)))
                .thenAnswer(invocation -> invocation.getArgument(0));

        // when
        TaskOutput output = useCase.execute(input);

        // then
        assertNotNull(output);
        assertNotNull(output.id());
        assertEquals("Estudar java", output.title());
        assertEquals(Optional.of("Finalizar"), output.description());

        verify(repository, times(1)).save(any(Task.class));
    }

}