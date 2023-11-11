package com.tcs.feingexercise.userservice.config;


import com.tcs.feingexercise.userservice.exception.BadRequestException;
import com.tcs.feingexercise.userservice.exception.InternalServerErrorException;
import com.tcs.feingexercise.userservice.exception.UserNotFoundException;
import feign.Response;
import feign.codec.ErrorDecoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomErrorDecoder implements ErrorDecoder {


    @Override
    public Exception decode(String methodKey, Response response) {
        switch (response.status()){
            case 400:
                return new BadRequestException("Bad Request!");
            case 404:
                return new UserNotFoundException("Product Not Found!");
            case 500:
                return new InternalServerErrorException("Internal Server Error!");
            default:
                return new Exception("Generic exception");
        }
    }

    @Bean
    public ErrorDecoder errorDecoder() {
        return new CustomErrorDecoder();
    }

}
