# Feature : Get my study plans and completed study plans and study review plans for today

As an User
I want to check study plans, completed plans and review plans for today
So that I can check what I should study new things and review and plans what I completed.

Scenario : get study plans, completed plans and review plans for today
    Given session
    When they is requested
    then they can be showed from webpage.

Scenario : failed to get study plans, completed plans and review plans for today because of unauthenticated problem
    Given unauthenticated session
    When it is requested
    then you can see unauthenticated error page
