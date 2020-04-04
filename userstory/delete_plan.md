# Feature : Delete Study Plan

As an User
I want to delete my study plan in my ToDoList for today
So that I can remove my plan what I added before.

Scenario : study plan is deleted
    Given study plan what you want to remove
    When it is deleted
    then study plan is deleted from your ToDoList for today

Scenario : failed to delete study plan because of invalid study plan
    Given invalid study plan number
    When it is deleted
    then nothing happen.
