package com.sy.example.core.convertor;

import com.sy.example.core.dto.TaskDTO;
import com.sy.example.core.entity.Task;

public class TaskDTOConvertor {

    public static class Builder {
        private Task task = new Task();

        public Builder setTask(Task task) {
            this.task = task;
            return this;
        }

        public TaskDTO build() {
            TaskDTO taskDTO = null;
            if(task != null) {
                taskDTO = new TaskDTO(task);
                taskDTO.setOwner(task.getOwner().split(","));
            }
            return taskDTO;
        }
    }
    public static TaskDTOConvertor.Builder newBuilder() {
        return new Builder();
    }
}
