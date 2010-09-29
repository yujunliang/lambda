Given <term> year loan of <amount> at <rate> in <country> for <first_time> first time buyer with <borrowed> borrowed application fee <fee>
When we calculate periodic payment
Then monthly payment is <payment>, stamp duty is <stampduty> and first month payment is <first>

Examples:

|term|amount  |rate|country|first_time|borrowed|   fee|   payment|stampduty|     first|
|  10|  100000| 3.7|WL     |          |non     |  0.00|   3747.90|  3000.00|   6747.90|
|  10|  200000| 4.7|NR     |          |        |100.00|   9442.85|     0.00|   9442.85|
|  10|10000000|10.7|NR     |non       |non     |100.00|1070005.39| 32100.16|1102205.55|
|  10|  100000| 3.7|NR     |non       |non     |500.00|   3747.90|   112.44|   4360.34|
|  10|  100000| 3.7|WL     |          |non     |  0.00|   3747.90|  3000.00|   6747.90|
|  10|  100000| 3.7|GD     |          |non     |  0.00|   3747.90|    74.96|   3822.86|
