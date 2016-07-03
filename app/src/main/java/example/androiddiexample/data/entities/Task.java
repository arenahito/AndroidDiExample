package example.androiddiexample.data.entities;

import lombok.Data;

@Data
public class Task {

    private int id;

    private String text;

    public Task(String text) {
        this(-1, text);
    }

    public Task(int id, String text) {
        this.id = id;
        this.text = text;
    }

    @Override
    public Task clone() {
        return new Task(id, text);
    }

    @Override
    public String toString() {
        return String.format("id=%d, text=%s", id, text);
    }

}
