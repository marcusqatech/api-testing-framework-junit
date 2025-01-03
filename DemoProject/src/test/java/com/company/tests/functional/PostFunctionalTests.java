package com.company.tests.functional;

import com.company.api.PostApiClient;
import com.company.constants.StatusCodes;
import com.company.utils.FileUtils;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PostFunctionalTests {
    PostApiClient apiClient = new PostApiClient();

    @Test
    public void testGetAllPosts() {
        // Call the API
        Response response = apiClient.getAllPosts();

        // Save the response to a file
        String directory = "output/json-responses";
        String fileName = "getAllPostsResponse.json";
        FileUtils.saveResponseToFile(directory, fileName, response.getBody().asString());

        // Assert the status code
        Assert.assertEquals(response.getStatusCode(), StatusCodes.OK);

        // Log the response body
        System.out.println("Response Body: " + response.getBody().asString());
    }

    @Test
    public void testCreatePost() {
        // Call the API
        Response response = apiClient.createPost("Demo Title", "Demo Body", 1);

        // Save the response to a file
        String directory = "output/json-responses";
        String fileName = "createPostResponse.json";
        FileUtils.saveResponseToFile(directory, fileName, response.getBody().asString());

        // Assert the status code
        Assert.assertEquals(response.getStatusCode(), StatusCodes.CREATED);

        // Log the response body
        System.out.println("Response Body: " + response.getBody().asString());
    }
}
