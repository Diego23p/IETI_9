package eci.ieti.data.model;

import org.springframework.data.annotation.Id;

/**
 *
 * @author Diego23p
 */
public class Todo {
    @Id
    private String id;
    
    private String description,  dueDate, responsible, status;
    
    private int priority;
    
    public Todo() {
    }
    
    public Todo(String description, int priority, String dueDate, String responsible, String status) {
        this.description = description;
        this.priority = priority;
        this.dueDate = dueDate;
        this.responsible = responsible;
        this.status = status;
    }  

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public String getResponsible() {
        return responsible;
    }

    public void setResponsible(String responsible) {
        this.responsible = responsible;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Todo{" + "id=" + id + ", description=" + description + ", priority=" + priority + ", dueDate=" + dueDate + ", responsible=" + responsible + ", status=" + status + '}';
    }
    
   
}
