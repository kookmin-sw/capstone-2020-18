# Feature : Updpate Study Plan in Today's ToDoList

As an User
I want to update my study plan in ToDoList for today
So that I can update my study plan in ToDoList for today

Scenario : study plan is updated to new one.
    Given updated study plan
    When it is updated
    then study plan what you want to change is updated.

Scenario : study plan is rejected to update with less than 5 length words
    Given value length less than 5
    When it is updated
    then notify to need to fit the requirement that value length need to be from 5 to 50

Scenario : study plan is rejected to update with more than 50 length words
    Given value length less than 5
    When it is updated
    then notify to need to fit the requirement that value length need to be from 5 to 50

Scenario : failed to update study plan because of invalid study plan
    Given invalid study plan number
    When it is updated
    then nothing happen.
