# Feature : Register Study Plan

As an User
I want to register my study plan into ToDoList for today
So that I can add new study plan and check my work.

Scenario : new study plan is added
    Given new study plan
    When it is added
    then new study plan is added into todolist

Scenario : failed to add study plan as value length less than 5
    Given value length less than 5
    When it is added
    then notify to need to fit the requirement that value length need to be from 5 to 50

Scenario : failed to add study plan as value that length is over 50
    Given study plan value that length is over 50
    When it is added
    then notify to need to fit the requirement that value length need to be from 5 to 50
