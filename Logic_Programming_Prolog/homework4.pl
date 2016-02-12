%facts
parent(pete,mike).
parent(pete,julie).
parent(pete,amanda).

parent(mary,mike).
parent(mary,julie).
parent(mary,amanda).

father(pete, mike).
father(pete, julie).
father(pete, amanda).

mother(mary, mike).
mother(mary, julie).
mother(mary, amanda).

aunt(debbie, mike).
aunt(debbie, julie).
aunt(debbie, amanda).

uncle(harry, mike).
uncle(harry, mike).
uncle(harry, amanda).

grandparent(gertrude, mike).
grandparent(gertrude, julie).
grandparent(gertrude, amanda).

female(mary).
female(amanda).
female(debbie).
female(julie).
female(gertrude).

male(mike).
male(pete).
male(harry).

sibling(mike,julie).
sibling(mike,amanda).
sibling(amanda,mike).
sibling(julie,mike).
sibling(julie, amanda).
sibling(amanda, julie).

sister(julie, mike).
sister(amanda, mike).
sister(julie, amanda).
sister(amanda, julie).

brother(mike, julie).
brother(mike, amanda).

son(mary, mike).
son(pete, mike).

daughter(mary, julie).
daughter(mary, amanda).
daughter(pete, julie).
daughter(pete, amanda).

%rules
father(X,Y):-male(X),parent(X,Y).
mother(X,Y):-female(X),parent(X,Y).
aunt(X,Y):-sister(X,Z),parent(Z,Y).
uncle(X,Y):-brother(X,Z),parent(Z,Y).
grandparent(A,B):-parent(A,C),parent(C,B).
sibling(A,B):-parent(C,A),parent(C,B),A\=B.
sister(A,B):-sibling(A,B),female(A).
brother(A,B):-sibling(A,B),male(A).
son(S,P):-male(S),parent(P,S).
daughter(D,P):-female(S),parent(P,D).


