package com.company.api;

import com.company.constants.ApiEndpoints;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class PostApiClient {

    public PostApiClient() {
        // Set the base URI for RestAssured
        RestAssured.baseURI = ApiEndpoints.BASE_URL;
    }


    // Method to get all posts
    public Response getAllPosts() {
        return RestAssured
                .given()
                .get(ApiEndpoints.POSTS)
                .then()
                .log().all()
                .extract().response();
    }


    // Method to get a post by ID
    public Response getPostById(int postId) {
        return RestAssured
                .given()
                .pathParam("id", postId)
                .get(ApiEndpoints.POST_BY_ID)
                .then()
                .log().all()
                .extract().response();
    }




    public Response createPost(String title, String body, int userId) {
        return given()
                .header("Content-Type", "application/json")
                .body("{\"title\":\"" + title + "\",\"body\":\"" + body + "\",\"userId\":" + userId + "}")
                .post(ApiEndpoints.POSTS);
    }
}
