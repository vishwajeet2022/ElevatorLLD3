package org.example;

import lombok.Data;

@Data
public class Request {
    int floor;
    Direction direction;

    Request(int floor,Direction direction){
        this.floor = floor;
        this.direction = direction;
    }
}
