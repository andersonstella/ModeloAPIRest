package taskmanager.infrastructure.repository;

import taskmanager.domain.TaskRepository;
import taskmanager.domain.TaskRepositoryTest;

class InMemoryTaskRepositoryTest extends TaskRepositoryTest {
    
    @Override
    protected TaskRepository createRepository() {
        return new InMemoryTaskRepository();
    }

}