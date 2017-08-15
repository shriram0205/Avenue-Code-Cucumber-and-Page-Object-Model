Feature: Sub Tasks Bug Tracker

Scenario: The task description field of the manage sub tasks is not read only

Given click on the myTasks page link.
When Navigate to the manage sub tasks page for a task
Then check if the name of the task displayed on manage sub task page is read only
