# Write your MySQL query statement below
# select Person.lastName, Person.firstName, Address.city, Address.state from Person left join Address on Person.personId = Address.personId;

select lastName, firstName, city, state from Person left join Address on Person.personId = Address.personId;