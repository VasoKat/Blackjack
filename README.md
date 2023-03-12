# Blackjack
Blackjack Game in Java
Rules of the game

In blackjack the goal is to get cards (hand) so that their total points are as close as possible to 21
(without exceeding it), and to be more than those of the dealer. Cards give as many points
as their number, figures give 10, and the ace gives 1 or 11 points, whatever is the best for the score
of the player. The game is played as follows. The player bets an amount (bet). The dealer has a river of cards
consisting of one or more decks of cards. He gives one card to all players and draws one himself.
All cards are open. He then deals another round of cards to everyone and one of him, closed.
First the dealer checks if he has blackjack (21 points with two cards). If yes, then takes the bets from
all players except those who also have blackjack. If he doesn't, and a player has blackjack,
is automatically paid 1.5 times the money he bet.
The dealer then plays each player's hand. If the player has two of a kind (eg, two 8) then
can do split. This means that he essentially has two hands, each with one of the cards. Subsequently
each hand is played normally. The other option the player has before starting to play is to double his bet.
If he doubles, then the dealer deals him only one card and stops. If he does none of these, he plays his hand normally.
At each step he has the choice to take a card (hit) or to stop (stand). He takes cards until he decides to stop. 
The player's final score is the sum of the points of his cards. If he exceeds 21 points he automatically loses (burns),
and pays the bet. The dealer plays when he is done with all players. The dealer draws cards while the sum of his points
is less than 17. If it exceeds 21 he is burned and pays all players left (not burned or not
have blackjack). Otherwise, whoever has the highest sum of points wins, and the winner is paid as much
is the bet. If we have a tie on points, nobody wins.