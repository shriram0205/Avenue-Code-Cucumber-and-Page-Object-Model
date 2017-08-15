Feature: Create task bug tracker

Scenario: Task created is not of minimum length three

Given Once logged in with credentials, navigate to My Tasks link on the Nav bar.
When Create a task
Then The task created is not of minimum three characters