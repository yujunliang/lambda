Given <term> year lease of <amount> with <residual_value> at <rate> in <country> with application fee <fee>
When we calculate periodic payment
Then monthly payment is <payment>, stamp duty is <stampduty> and first month payment is <first>

Examples:

|term|amount  |rate| residual_value |country|   fee|   payment|stampduty|     first|
|  10|  100000| 3.7|          50000 |WL     |  0.00|   5966.67|  3000.00|   8966.67|
|  10|  200000| 4.7|         100000 |NR     |100.00|  14933.33|   448.00|  15481.33|
|  10|10000000|10.7|        5000000 |NR     |100.00|1646666.67| 49400.00|1696166.67|
|  10|  100000| 3.7|          50000 |NR     |500.00|   5966.67|   179.00|   6645.67|
|  10|  100000| 3.7|          50000 |WL     |  0.00|   5966.67|  3000.00|   8966.67|
|  10|  100000| 3.7|          50000 |GD     |  0.00|   5966.67|   119.33|   6086.00|
