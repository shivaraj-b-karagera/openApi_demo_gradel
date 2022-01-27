package com.example.openapigradel;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/api")
public class helloController {
    @ApiOperation(value = "getGreeting", notes="get greeting",nickname = "getGreeting")
    //Describes an operation or typically a HTTP method against a specific path.
    // Operations with equivalent paths are grouped in a single Operation Object.
    // A combination of a HTTP method and a path creates a unique operation.
    @RequestMapping(method = RequestMethod.GET, value = "demo")

    @ApiResponses(value = {
            @ApiResponse(code = 500, message = "Server error"),
            @ApiResponse(code = 404, message = "Service not found"),
            @ApiResponse(code = 200, message = "Successful retrieval")})

    //This annotation is used to describe the expected responses for the REST API.
    // The @ApiResponse describes a concrete possible response.
    // It cannot be used directly on the method and needs to be included in the array value of @ApiResponses

    public String sayHello(@ApiParam(value = "testId",
            required = true, defaultValue = "test")@PathVariable() final int testId)

    // The @ApiParam annotation helps to specify the name, type, description (value),
    // and example value of the parameter. Moreover, we can specify whether the parameter is required or optional

    {
        return "Hello World from OpenApi-Swagger";
    }
}
