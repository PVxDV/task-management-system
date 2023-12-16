package com.pvxdv.taskmanagementsystem.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.pvxdv.taskmanagementsystem.converter.TaskToTaskDTO;
import com.pvxdv.taskmanagementsystem.dto.TaskDTO;
import com.pvxdv.taskmanagementsystem.dto.UserDTO;
import com.pvxdv.taskmanagementsystem.enums.Priority;
import com.pvxdv.taskmanagementsystem.enums.Status;
import com.pvxdv.taskmanagementsystem.model.Comment;
import com.pvxdv.taskmanagementsystem.model.Task;
import com.pvxdv.taskmanagementsystem.model.User;
import com.pvxdv.taskmanagementsystem.service.TaskService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@WebMvcTest(TaskController.class)
class TaskControllerTest {
    private MockMvc mockMvc;

    private UserDTO userDTOOne;
    private UserDTO userDTOTwo;
    private User userOne;
    private User userTwo;
    private TaskDTO taskDTO;
    private Task task;
    private Comment comment;
    List<Comment> comments;

    @MockBean
    private TaskService taskService;

    @BeforeEach
    void setUp() {
        userDTOOne = new UserDTO(1L, "TestName1", "TestLastName1", "TestMiddleName1",
                LocalDate.of(1993, 3, 18), "testEmail1", "login1");
        userDTOTwo = new UserDTO(1L, "TestName1", "TestLastName1", "TestMiddleName1",
                LocalDate.of(1994, 4, 19), "testEmail1", "login2");
        userOne = new User(3L, "TestName3", "TestLastName3", "TestMiddleName1",
                LocalDate.of(1995, 5, 20), "testEmail3", "login3");
        userTwo = new User(4L, "TestName4", "TestLastName3", "TestMiddleName1",
                LocalDate.of(1996, 6, 21), "testEmail4", "login4");

        task = new Task(5L, "testTask", "test TaskController", Status.COMPLETED, Priority.HIGH, userOne, userTwo,
                null, LocalDate.of(2023, 12, 16), null);

        comment = new Comment(6L, userOne, task, "test comment", LocalDate.of(2023, 12, 16));
        comments = new ArrayList<>();
        comments.add(comment);
        task.setComments(comments);

        TaskToTaskDTO taskToTaskDTO = new TaskToTaskDTO();
        taskDTO = taskToTaskDTO.convert(task);

        mockMvc = MockMvcBuilders.standaloneSetup(taskService).build();
    }

    @Test
    void getTaskByIdSuccess() throws Exception {
        Mockito.when(taskService.findTaskById(ArgumentMatchers.any())).thenReturn(taskDTO);
        MvcResult mvcResult = mockMvc.perform(get("/api/v1/tasks/5")).andReturn();

        ObjectMapper objectMapper = new ObjectMapper();

        assertEquals(objectMapper.writeValueAsString(taskDTO), mvcResult.getResponse().getContentAsString());
    }

    @Test
    void editTask() {
    }

    @Test
    void createTask() {
    }

    @Test
    void deleteTask() {
    }

    @Test
    void assignExecutor() {
    }

    @Test
    void changeStatus() {
    }

    @Test
    void getTasksByAuthor() {
    }

    @Test
    void findTaskById() {
    }

    public static String convertToJson(Object object) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.registerModule(new JavaTimeModule());
            objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd"));

            return objectMapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}