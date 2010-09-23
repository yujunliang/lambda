Given <term> year lease of <amount> with <residual_value> at <rate> in <country> for <buyer> first time buyer with <borrowed> borrowed application fee <fee>
When we calculate periodic payment
Then monthly payment is <payment>, stamp duty is <stampduty> and first month payment is <first>

Examples:

|term|amount  |rate| residual_value |country|buyer|borrowed|   fee|   payment|stampduty|     first|
|  10|  100000| 3.7|          50000 |WL     |     |non     |  0.00|   5966.67|  3000.00|   8966.67|
|  10|  200000| 4.7|         100000 |NR     |     |        |100.00|  14938.87|     0.00|  14938.87|
|  10|10000000|10.7|        5000000 |NR     |non  |non     |100.00|1646666.67| 49400.00|1696166.67|
|  10|  100000| 3.7|          50000 |NR     |non  |non     |500.00|   5966.67|   179.00|   6645.67|
|  10|  100000| 3.7|          50000 |WL     |     |non     |  0.00|   5966.67|  3000.00|   8966.67|
|  10|  100000| 3.7|          50000 |GD     |     |non     |  0.00|   5966.67|   119.33|   6086.00|
