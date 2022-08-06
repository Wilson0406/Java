# Write your MySQL query statement below

select 
    Users.name name, 
    sum(Transactions.amount) balance 
from `Users` as Users 
join `Transactions` as Transactions 
on Users.account = Transactions.account 
group by Users.account 
having balance > 10000;