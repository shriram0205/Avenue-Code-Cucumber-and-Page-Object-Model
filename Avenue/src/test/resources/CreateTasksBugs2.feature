Feature: Empty task name Bug tracker

Scenario: Empty task name when edited throws an error

Given Once the user has logged in. navigate to the My Tasks link on the nav bar.
When create a task name without entering anything by clicking on the plus button.
Then Try modifying the name of the task and it throws an unexpected error.
