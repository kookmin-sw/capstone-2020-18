# Feature : Complete Study Plan in Today's ToDoList

As an User
I want to make my study plan be completed from ToDoList and input it into completed list for today
So that I can check completed study plans in completed list for reviewing in today

Scenario : study plan is completed
    Given study plan number
    When it is completed
    then completed study plan is removed from todolist and added into completed list.

Scenario : failed to complet study plan because of invalid study plan
    Given invalid study plan number
    When it is completed
    then nothing happen.
