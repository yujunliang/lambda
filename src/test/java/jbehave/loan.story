Given new worksheet
And principal of 100000
And i am a first-time buyer
And term of 10 years
And interest of 3.7%
And I am in WL
When we calculate periodic payment
Then 3747.90 results
And 3000.00 stampduty
And first month payment is 6747.90

Given new worksheet
And principal of 200000
And term of 10 years
And interest of 4.7%
And I am in NR
And i am a first-time buyer
And I borrow application fee
And application fee 100
When we calculate periodic payment
Then 9442.85 results
And 0.00 stampduty
And first month payment is 9442.85

Given new worksheet
And principal of 10000000
And term of 10 years
And interest of 10.7%
And I am in NR
And application fee 100
When we calculate periodic payment
Then 1070005.39 results
And 32100.16 stampduty
And first month payment is 1102205.55

Given new worksheet
And principal of 100000
And term of 10 years
And interest of 3.7%
And I am in NR
And application fee 500
When we calculate periodic payment
Then 3747.90 results
And 112.44 stampduty
And first month payment is 4360.34

Given new worksheet
And principal of 100000
And i am a first-time buyer
And term of 10 years
And interest of 3.7%
And I am in WL
When we calculate periodic payment
Then 3747.90 results
And 3000.00 stampduty
And first month payment is 6747.90

Given new worksheet
And principal of 100000
And i am a first-time buyer
And term of 10 years
And interest of 3.7%
And I am in GD
When we calculate periodic payment
Then 3747.90 results
And 74.96 stampduty
And first month payment is 3822.86