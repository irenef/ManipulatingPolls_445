Assumptions for problem 4
1. when someone sees its second person getting more votes than the first choice, the person will switch to voting for the second choice. 
2. someone will never vote for their least favorite candidate, $z$. Because it will make people who has $z$ as a second choice vote for $z$ in the final round because $c$ winning is prefered over their least favorite candidate winning.  

Polling Strategy: 
							               $A \> B \> C$
Let vote $i$'s preference be $x \> y \> z$. 

case ?: if close/balanced --> vote for $x$  

Case 1: $x \> y \> z$ --> $i$ would report $x$, because $i$ wants to sway people who have $x$ as the second favorite to vote for $x$. 

Case 2: $x \> z \> y$ --> $i$ would report $x$, because $i$ wants to sway people who have $x$ as the second favorite to vote for $x$.  

Case 3: $y \> x \> z$ --> $i$ would report $x$, because $i$ wants to sway people who have $x$ as the second favorite to vote for $x$.  
--poll: report y when threshold: y-x > 0.3

Case 4: $y \> z \> x$ --> $i$ would report $x$ in the first few rounds of P. If $i$ realizes it is \textbf{unrealistic} for $x$ to win, $i$ will switch reporting and voting for $y$. Because $i$ would rather $y$ win than $z$. 
--poll: report y 

Case 5: $z \> y \> x$ --> if the $i$ would vote for $y$
--poll: report y if y-x = (0.3, 0.1) 

Case 6: $z \> x \> y$  
--poll: report x

Never line in first 1/10 rounds, at least 3 



If the poll is heavily inbalanced, we know the first and the second favorite in the society are definitely the first and the second in all the polls. Because there is never any incentive to vote for your least favorite candidate. 

