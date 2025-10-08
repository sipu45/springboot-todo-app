package com.app.Todo.Repository;

import com.app.Todo.Models.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task , Long>{
}
