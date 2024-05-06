package com.example.springcloudvaultdemo.dto;


import java.time.LocalDateTime;

public record GenericResponse(boolean success, String message, Object data, int code, LocalDateTime timestamp) {
}