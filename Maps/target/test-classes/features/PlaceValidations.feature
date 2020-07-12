@Place
Feature: Place Validation

  Scenario Outline: Verify adding place by providing valid parameters
    Given a payload with "<name>", "<language>", "<address>", "<accuracy>", "<phoneNum>", "<latitude>", "<longitude>"
    When user calls "<API>" with "<request>" http request
    Then the API call is "<response>" with "<responseCode>"
    And the "<key>" in the response body is "<value>"
    And the place_id in the response body maps to "<name>" from "getPlaceAPI"

    Examples:
      | name          | language | address                        | accuracy | phoneNum      | latitude | longitude | API  | request     | response | responseCode | key    | value |
      | Saurabh Surve | Marathi  | Western zone, Kaziranga, Assam | 90       | +919967370025 | 30.216   | -2.154    | POST | AddPlaceAPI | SUCCESS  | 200          | status | OK    |