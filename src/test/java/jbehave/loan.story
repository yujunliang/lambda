Given principal of 100000
And i am a first-time buyer
And term of 10 years
And interest of 3.7%
And I am in WL
When we calculate periodic payment
Then 3747.90 results
And 3000.00 stampduty

Given principal of 200000
And term of 10 years
And interest of 4.7%
And I am in NR
And i am a first-time buyer
When we calculate periodic payment
Then 9442.85 results
And 0.00 stampduty

Given principal of 10000000
And term of 10 years
And interest of 10.7%
And I am in NR
When we calculate periodic payment
Then 1070016.09 results
And 32100.48 stampduty

Given principal of 100000
And term of 10 years
And interest of 3.7%
And I am in NR
When we calculate periodic payment
Then 3751.65 results
And 112.55 stampduty

Given principal of 100000
And i am a first-time buyer
And term of 10 years
And interest of 3.7%
And I am in WL
When we calculate periodic payment
Then 3747.90 results
And 3000.00 stampduty