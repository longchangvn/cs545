package cs545.labs.lab3.dto;

import lombok.Data;

@Data
public class PostRequestModel {
    long id;
    String title;
    String content;
    String author;
}
