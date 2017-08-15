Feature: Tracking sub task bugs

Scenario: Able to create a sub task without specifying the mandatory fields

Given After Navigating to the manage sub tasks section
Then create a sub task without entering the sub task description and due date
When An empty sub task is created. As per the requirements sub task name is mandatory