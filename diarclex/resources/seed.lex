//Nouns
tomato :- N : (lambda $0:e (name:<e,<e,t>>  $0 tomato:e))
surface :- N : (lambda $0:e (name:<e,<e,t>> $0 surface:e))
cutting board :- N : (lambda $0:e (name:<e,<e,t>> $0 cuttingboard:e))

//Modifiers / Articles
the :- S/N : (lambda $0:<e,t> (lambda $1:e (and:<t*,t> (desc:<e,<d,t>> $1 definite:d) ($0 $1))))
the :- S/NP : (lambda $0:<e,t> (lambda $1:e (and:<t*,t> (desc:<e,<d,t>> $1 definite:d) ($0 $1))))
the :- NP/NP : (lambda $0:<e,t> (lambda $1:e (and:<t*,t> (desc:<e,<d,t>> $1 definite:d) ($0 $1))))
the :- NP/N : (lambda $0:<e,t> (lambda $1:e (and:<t*,t> (desc:<e,<d,t>> $1 definite:d) ($0 $1))))

blue :- N/N : (lambda $0:<e,t> (lambda $1:e (and:<t*,t> (desc:<e,<d,t>> $1 blue:d) ($0 $1))))
blue :- S/N : (lambda $0:<e,t> (lambda $1:e (and:<t*,t> (desc:<e,<d,t>> $1 blue:d) ($0 $1))))
blue :- S/NP : (lambda $0:<e,t> (lambda $1:e (and:<t*,t> (desc:<e,<d,t>> $1 blue:d) ($0 $1))))

very :- S/N/N : (lambda $0:<e,t> (lambda $1:<e,t> (lambda $2:e (and:<t*,t> (desc:<d,t> very:d) ($0 $2) ($1 $2)))))

makesentence :- S/N : (lambda $0:t (and:<t*,t> (makesentence:<t,t> $0)))
makesentence :- S/N : (lambda $0:<e,t> (and:<t*,t> (makesentence:<<e,t>,t> $0)))

loathe :- (S\NP)/NP : (lambda $0:e (lambda $2:e (lambda $1:a (and:<t*,t> (loathe:<a,t> $1) (theme:<a,<e,t>>  $1 $0) (actor:<a,<e,t>> $1 $2)))))

you :- N : (lambda $0:e (name:<e,<e,t>> self:e $0))
place :- (S\N)/PP/NP : (lambda $0:<e,t> (lambda $1:t (lambda $2:<e,t> (lambda $3:a (and:<t*,t> (place:<a,t> $3) (obj:<a,<<e,t>,t>> $3 $0) (actor:<a,<<e,t>,t>> $3 $2) (loc:<a,<t,t>> $3 $1) )))))
on :- PP/NP : (lambda $0:<e,t> (on:<<e,t>,t> $0))
on :- S/NP : (lambda $0:<e,t> (on:<<e,t>,t> $0))

x :- S/PP : (lambda $0:t (x:<t,t> $0))

in front of :- S\N/N : (lambda $0:<e,t> (lambda $1:<e,t> (lambda $2:e (and:<t*,t> (desc:<e,<d,<<e,t>,t>>> $2 infrontof:d $0) ($1 $2))))
in front of :- NP\N/N : (lambda $0:<e,t> (lambda $1:<e,t> (lambda $2:e (and:<t*,t> (desc:<e,<d,<<e,t>,t>>> $2 infrontof:d $0) ($1 $2))))

down :- PP : down:t

a :- NP/N : (lambda $0:<e,t> (lambda $1:e (and:<t*,t> (desc:<e,<d,t>> $1 indefinite:d) ($0 $1))))

place :- (S/PP)/NP : (lambda $0:<e,t> (lambda $1:t (lambda $3:a (and:<t*,t> (place:<a,t> $3) (obj:<a,<<e,t>,t>> $3 $0) (actor:<a,<<e,t>,t>> $3 (lambda $2:e (name:<e,<e,t>> self:e $2))) (loc:<a,<t,t>> $3 $1) ))))

before :- S/S/S : (lambda $0:<a,t> (pre:<<a,t>,t> $0))

you need to :- EMPTY : self:e

before :- S/S/S : (lambda $0:<a,t> (lambda $1:<a,t> (and:<t*,t> (modifyaction:<<a,t>,t> $1) (precondition:<<a,t>,t> $0))))




//Example 2------------------------------------------------------------------------------------------------------------------------------------
//if not definite, is it indefinite (ie. food as a concept)
drinks :- N : (lambda $0:e (name:<e,<e,t>>  $0 drinks:e))
food :- N : (lambda $0:e (name:<e,<e,t>> $0 food:e))
notepad :- N : (lambda $0:e (name:<e,<e,t>>  $0 notepad:e))

//tables is indefinite in "waiting tables"
tables :- N : (lambda $0:e (and:<t*,t> (desc:<e,<d,t>> $0 plural:d) (name:<e,<e,t>> $0 table:e)))

//inifinites
//need type changing rule https://www.cl.cam.ac.uk/teaching/1011/L107/clark-lecture4.pdf

//idiomatic
//gerund phrase, id how to do his yet
waiting tables :- GP : (lambda $0:a (name:<a,<a,t>> $0 waitingtables:a))

//subordinating conjunction

//asked their boss for,   ask for
ask for :- (S\N)/N : (lambda $0:e (lambda $2:e (lambda $1:a (and:<t*,t> (askfor:<a,t> $1) (obj:<a,<e,t>>  $1 $0) (actor:<a,<e,t>> $1 $2)))))
on :- PP : on:e
scribble :- (S/N)/PP : (lambda $0:e (lambda $1:<e,t> (lambda $2:a (and:<t*,t> (draw:<a,t> $2) (patient:<a,<<e,t>,t>> $2 $1) (loc:<a,<e,t>> $2 $0)))))
scribble :- (S/NP)/PP : (lambda $0:e (lambda $1:<e,t> (lambda $2:a (and:<t*,t> (draw:<a,t> $2) (patient:<a,<<e,t>,t>> $2 $1) (loc:<a,<e,t>> $2 $0)))))

