# Bank-Multithread
Bank produces list of transactions to process, worker threads process them simultaneously


first number: withdrawing account
second number: depositing account
third number: amount to trasnfer

Input:
14 4 32
17 6 104
18 12 175
19 4 103
5 10 64
15 13 110
8 5 67
1 19 81
1 2 150
.
.
.


Output:

Thread-0 Producing Transaction  - Trasnfer $119 from 2 to 17
Thread-2 Processing Transaction - Trasnfer $119 from 2 to 17
Thread-0 Producing Transaction  - Trasnfer $153 from 8 to 5
Thread-1 Processing Transaction - Trasnfer $153 from 8 to 5
Thread-1 Processing Transaction - Trasnfer $199 from 0 to 11
Thread-0 Producing Transaction  - Trasnfer $199 from 0 to 11
Thread-0 Producing Transaction  - Trasnfer $142 from 16 to 8
Thread-2 Processing Transaction - Trasnfer $142 from 16 to 8
Thread-2 Processing Transaction - Trasnfer $14 from 0 to 18
Thread-0 Producing Transaction  - Trasnfer $162 from 10 to 2
Thread-3 Processing Transaction - Trasnfer $162 from 10 to 2
Thread-1 Processing Transaction - Trasnfer $106 from 11 to 10
Thread-0 Producing Transaction  - Trasnfer $106 from 11 to 10
Thread-0 Producing Transaction  - Trasnfer $43 from 11 to 16
Thread-2 Processing Transaction - Trasnfer $43 from 11 to 16
Thread-0 Producing Transaction  - Trasnfer $133 from 13 to 5
Thread-3 Processing Transaction - Trasnfer $133 from 13 to 5

.
.
. for all transactions



Prints out final balances, all 1000 to ensure no thread updated a balance while another thread wasn't complete

Account: 0, Balance: 1000 Transaction Count: 10360
Account: 1, Balance: 1000 Transaction Count: 8880
Account: 2, Balance: 1000 Transaction Count: 10440
Account: 3, Balance: 1000 Transaction Count: 9840
Account: 4, Balance: 1000 Transaction Count: 10520
Account: 5, Balance: 1000 Transaction Count: 10520
Account: 6, Balance: 1000 Transaction Count: 9480
Account: 7, Balance: 1000 Transaction Count: 9440
Account: 8, Balance: 1000 Transaction Count: 8720
Account: 9, Balance: 1000 Transaction Count: 9000
Account: 10, Balance: 1000 Transaction Count: 9960
Account: 11, Balance: 1000 Transaction Count: 10520
Account: 12, Balance: 1000 Transaction Count: 9760
Account: 13, Balance: 1000 Transaction Count: 9640
Account: 14, Balance: 1000 Transaction Count: 10320
Account: 15, Balance: 1000 Transaction Count: 9840
Account: 16, Balance: 1000 Transaction Count: 10400
Account: 17, Balance: 1000 Transaction Count: 10560
Account: 18, Balance: 1000 Transaction Count: 11720
Account: 19, Balance: 1000 Transaction Count: 10080
